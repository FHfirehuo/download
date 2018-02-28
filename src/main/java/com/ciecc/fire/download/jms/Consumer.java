package com.ciecc.fire.download.jms;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ciecc.fire.download.domain.DownLoadTask;
import com.ciecc.fire.download.domain.Email;
import com.ciecc.fire.download.redis.DownloadRepository;
import com.ciecc.fire.util.DownUtil;

@Component
public class Consumer {
	
	@Autowired
	private DownloadRepository downloadRepository;

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String text) {
		System.out.println(text);
	}

	@JmsListener(destination = "mailbox")
	public void receiveMessage(Email email) {
		System.out.println("Received <" + email + ">");                                                                                                    
	}

	@JmsListener(destination = "downloadurl", containerFactory = "myFactory")
	public void receiveMessage(DownLoadTask task) {
		
		downloadRepository.save(task);
		
		final DownUtil downUtil = new DownUtil(task.getUrl(), task.getFileName(), 3);
		try {
			downUtil.download();
			new Thread(new Runnable() {
				@Override
				public void run() {
					double progress = 0;
					BigDecimal ba;
					try {
						do {
							progress = downUtil.getCompleteRate();
							ba = new BigDecimal(progress * 100);
							String percentage = ba.setScale(1, BigDecimal.ROUND_HALF_UP).toString(); //百分比
							downloadRepository.saveProgress(task.getId(), percentage);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} while (progress < 1);
						
						downloadRepository.complete(task.getId());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
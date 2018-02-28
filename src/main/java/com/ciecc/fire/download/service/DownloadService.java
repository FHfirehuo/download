package com.ciecc.fire.download.service;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ciecc.fire.download.domain.DownLoadTask;
import com.ciecc.fire.download.domain.SecurityUser;
import com.ciecc.fire.download.redis.DownloadRepository;
import com.ciecc.fire.download.tool.UserTool;

@Service
public class DownloadService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private DownloadRepository downloadRepository;
	
	
	@Autowired
	private Queue queue;

	public void download(String url, Integer sortId, String introduction) {
		
		
		/*if(setOps.isMember("url", url)){
			return ;
		}*/
		
		String fileName = url.substring(url.lastIndexOf("/")+1);
		/*if(setOps.isMember("file", fileName)){
			return ;
		}*/
		
		
		SecurityUser u = UserTool.getCurrentUser();
		sortId = 2;
		jmsTemplate.convertAndSend(queue, new DownLoadTask(u.getId(), url, sortId, introduction, fileName));
		//只有任务发布了才添加新增资源,防止网络出现错误导致资源丢失。
		downloadRepository.addUrl(url);
		downloadRepository.addFile(fileName);
	}

	public List<DownLoadTask> list() {
		SecurityUser u = UserTool.getCurrentUser();
		/*if(u.getAuthorities().contains("ADMIN")){
			
		}*/
		return downloadRepository.get(u.getId());
	}

}

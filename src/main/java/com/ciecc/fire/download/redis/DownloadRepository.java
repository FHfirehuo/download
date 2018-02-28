package com.ciecc.fire.download.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.ciecc.fire.download.domain.DownLoadTask;

@Repository
public class DownloadRepository {

	private final StringRedisTemplate template;
	private final ValueOperations<String, String> valueOps;
	
	@Resource(name="template")
	private SetOperations<String, String> setOps;
	
	@Resource(name="template")
	private ListOperations<String, String> listOps;
	
	@Resource(name="template")
	private HashOperations<String, String, String> hashOps;

	@Autowired
	public DownloadRepository(StringRedisTemplate template) {
		this.template = template;
		valueOps = template.opsForValue();
	}

	public void save(DownLoadTask task) {
		long downId = valueOps.increment(KeyUtils.DownId(), 1L);
		task.setId(downId);
		BoundHashOperations<String, String, String> downOps = template.boundHashOps(KeyUtils.downId(downId));
		downOps.put("filename", task.getFileName());
		downOps.put("url", task.getUrl());
		downOps.put("userid", String.valueOf(task.getUserid()));
		downOps.put("sort", String.valueOf(task.getSortid()));
		downOps.put("introduction", task.getIntroduction());
		//BoundSetOperations<String, String> userOps = template.boundSetOps(KeyUtils.downUser(task.getUserid()));
		//userOps.add(String.valueOf(downId));
		//setOps.add(KeyUtils.downUser(task.getUserid()), String.valueOf(downId));
		listOps.leftPush(KeyUtils.downUser(task.getUserid()), String.valueOf(downId));
	}

	public void saveProgress(long id, String percentage) {
		//setOps.add(KeyUtils.downUser(task.getUserid()), percentage);
		hashOps.put(KeyUtils.downProgress(), String.valueOf(id), percentage);
	}

	public void complete(long id) {
		hashOps.delete(KeyUtils.downProgress(), String.valueOf(id));
	}

	public void addFile(String fileName) {
		setOps.add(KeyUtils.file(), fileName);
	}

	public void addUrl(String url) {
		setOps.add(KeyUtils.url(), url);
	}

	public List<DownLoadTask>  get(long id) {
		//setOps.add(KeyUtils.downUser(task.getUserid()), String.valueOf(downId));
		//setOps.randomMember(key);
		List<DownLoadTask> tasks = new ArrayList<>();
		List<String> ids = listOps.range(KeyUtils.downUser(id), 0, 10);
		DownLoadTask task;
		//Iterator<String> ids.iterator();
		Map<String, String> downTasks;
		for(String s : ids){
			BoundHashOperations<String, String, String> downOps = template.boundHashOps(KeyUtils.downId(Long.valueOf(s)));
			downTasks = downOps.entries();
			task = new DownLoadTask();
			task.setId(Long.valueOf(s));
			task.setFileName(downTasks.get("filename"));
			task.setSortid(Integer.valueOf(downTasks.get("sort")));
			task.setIntroduction(downTasks.get("introduction"));
			String progress = hashOps.get(KeyUtils.downProgress(), String.valueOf(id));
			task.setProgress(progress == null ? "100" : progress );
			tasks.add(task);
			
		}
		return tasks;
	}
}

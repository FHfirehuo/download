package com.ciecc.fire.download.domain;

import java.io.Serializable;

public class DownLoadTask implements Serializable {

	private static final long serialVersionUID = -3787463238790077694L;
	private long id;
	private long userid;
	private String url;
	private String fileName;
	private int sortid;
	private String introduction;
	private String progress = "0";
	
	public DownLoadTask(long userid, String url, int sortid, String introduction) {
		this(userid, url, sortid, introduction, null);
		
	}

	public DownLoadTask(long userid, String url, int sortid, String introduction, String fileName) {
		this.userid = userid;
		this.url = url;
		this.sortid = sortid;
		this.introduction = introduction;
		this.fileName = fileName;
		if(fileName == null){
			this.fileName = url.substring(url.lastIndexOf("/")+1);
		}
		
	}

	public DownLoadTask() {
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSortid() {
		return sortid;
	}

	public void setSortid(int sortid) {
		this.sortid = sortid;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownLoadTask [userid=").append(userid).append(", url=").append(url).append(", fileName=")
				.append(fileName).append(", sortid=").append(sortid).append(", introduction=").append(introduction)
				.append(", progress=").append(progress).append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

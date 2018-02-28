package com.ciecc.fire.download.redis;

public class KeyUtils {
	static final String DOWNLOAD = "down:";
	static final String USER = "user:";

	public static String DownId() {
		return "downid";
	}

	public static String downId(long downId) {
		return DOWNLOAD + downId;
	}

	public static String downUser(long userid) {
		return DOWNLOAD + USER + userid;
	}

	public static String downProgress() {
		return DOWNLOAD + "progress";
	}

	public static String file() {
		return "file";
	}

	public static String url() {
		return DOWNLOAD + "url";
	}

}

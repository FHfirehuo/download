package com.ciecc.fire.util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 	文件功能简述： 描述一个URL地址是否有效
 * @author fire
 *
 */
public class URLAvailability {

	public static final int FILE_IS_TOO_SMALL = 1;
	private static URL url;
	private static HttpURLConnection conn;
	private int fileSize;
	/**
	 * 功能：检测当前URL是否可连接或是否有效, 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用
	 * 
	 * @param urlStr
	 *            指定URL网络地址
	 * @return URL
	 */
	public synchronized static int isConnect(String urlStr) {
		int counts = 0;
		if (urlStr == null || urlStr.length() <= 0) {
			return 0;
		}
		while (counts < 5) {
			try {
				
				url = new URL(urlStr);
				conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept",
						"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
								+ "application/x-shockwave-flash, application/xaml+xml, "
								+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
								+ "application/x-ms-application, application/vnd.ms-excel, "
								+ "application/vnd.ms-powerpoint, application/msword, */*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				conn.setRequestProperty("Connection", "Keep-Alive");
				// 得到文件大小
				int fileSize = conn.getContentLength();
				System.out.println(fileSize);
				if(fileSize < 5 * 1024 * 1024){
					return FILE_IS_TOO_SMALL;
				}
				System.out.println("连接第 " + counts + " 次");
				counts++;
			} catch (Exception ex) {
				counts++;
				System.out.println("URL不可用，连接第 " + counts + " 次");
				continue;
			}
		}
		return 0;
	}

}

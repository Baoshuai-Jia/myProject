package com.example.httpclientdemo.pojo;


import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public abstract class DownloadUtil {
	/**
	 * Logger for this class
	 */

	public static void makeResponseHeader(HttpServletResponse response, String fileName) {
		String utf8FileName = null;
		try {
			utf8FileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			utf8FileName = fileName;
		}
		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=" + utf8FileName + ";filename*=utf-8''" + utf8FileName);

	}
}

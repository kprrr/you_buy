package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component("property")
public class Property {
	public final String MESSAGE_FILE = "/WEB-INF/classes/config.properties";// 属性文件
	public String MESSAGE_FILE_temp = "config.properties";// 属性文件
	private String realPath = null;

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	/**
	 * @Description : 根据fromUserName取得对应值
	 * @param： String fromUserName
	 * @return Object
	 */
	public String getValueByKey(String fromUserName) {
		String fromUserNameMsgInfo = null;
		Properties property = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File(realPath + MESSAGE_FILE)));
			property.load(inputStream);
			fromUserNameMsgInfo = property.getProperty(fromUserName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fromUserNameMsgInfo;
	}
	
	public String getValueByKey_temp(String fromUserName) {
		String fromUserNameMsgInfo = null;
		Properties property = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File(realPath + MESSAGE_FILE_temp)));
			property.load(inputStream);
			fromUserNameMsgInfo = property.getProperty(fromUserName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fromUserNameMsgInfo;
	}
}

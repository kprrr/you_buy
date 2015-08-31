package com.base;

import com.juxinbox.sdk.PostOrGet;

public class Test {
	public static void main(String[] args) {
		String url = "http://wx.juxinbox.com/wx1414672931289";
		String result = PostOrGet.sendPost(url, "{\"content\":\"h\",\"msgType\":\"text\"}");
		System.out.println(result);
	}
}

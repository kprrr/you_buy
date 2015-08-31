package com.base;

public class BaseModel {

	public Boolean isNotNull(String str) {
		return str != null && str.length() > 0;
	}

	public Boolean isNotNull(Integer str) {
		return str != null;
	}
}

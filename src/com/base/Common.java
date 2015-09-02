package com.base;

import java.util.List;

import com.sys.model.region;


public class Common {
	
	// 设置静态变量，在tomcat启动时对其赋值
	public static String accessToken=null;
	public static List<region> regionList;
	public static String AppId = null;
	public static String AppSecret = null;
	
	 
	public static String getValueBykey(String key) {
		String region_name = null;
		if(regionList != null && regionList.size()>0) {
			for(region region : regionList) {
				if(key.equals(region.getRegion_id())) {
					region_name = region.getRegion_name();
					break;
				}
			}
		}
		return region_name;
	}
	
//	public static String getMsgValue(String msg_key, String type) {
//		if (msg_key == null) {
//			msg_key = "";
//		}
//		String getMsgValue = msg_key;
//		if (type != null && !"".equals(type)) {
//			if (workingSpaceList != null && workingSpaceList.size() > 0) {
//				for (int i = 0; i < workingSpaceList.size(); i++) {
//					if (type.equals(String.valueOf(workingSpaceList.get(i)[2]))
//							&& msg_key.equals(workingSpaceList.get(i)[0])) {
//						getMsgValue = workingSpaceList.get(i)[1].toString();
//						break;
//					}
//				}
//			}
//		}
//		return getMsgValue;
//	}
}

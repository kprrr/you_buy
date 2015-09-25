package com.weixin.dao;

import com.base.ServiceDao;
import com.weixin.model.ws_mess;

public interface WeiXinServerDao {
	
	/**
	 * 处理用户消息
	 */
	public String getMess(ServiceDao serviceDao,String url,ws_mess mess);
	
}

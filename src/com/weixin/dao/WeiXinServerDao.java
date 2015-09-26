package com.weixin.dao;

import com.front.service.UserService;
import com.weixin.model.ws_mess;

public interface WeiXinServerDao {
	
	/**
	 * 处理用户消息
	 */
	public String getMess(UserService userService,String url,ws_mess mess);
	
}

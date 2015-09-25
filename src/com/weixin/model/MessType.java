package com.weixin.model;

/**
 * 消息类型
 * 
 * @author 张宏
 * 
 */
public enum MessType {
	event,		//欢迎语
	text, 		//文本
	news, 		//图文
	music,		//音乐
	image,		//图片
	location,	//地理位置
    link,       //搜藏消息
	
	transfer_customer_service//多客服
}
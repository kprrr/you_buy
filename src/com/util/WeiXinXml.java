package com.util;

import java.util.Date;
import java.util.List;

import com.weixin.model.Image;
import com.weixin.model.ws_mess;


public class WeiXinXml {
	
	// 文本处理
	public static String text(ws_mess mess, String text) {
		StringBuffer xml = new StringBuffer();
		xml.append(String.format("<xml>"));
		xml.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>", mess.getFromUserName()));
		xml.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>",mess.getToUserName()));
		xml.append(String.format("<CreateTime>%s</CreateTime>",new Date().getTime()));
		xml.append(String.format("<MsgType><![CDATA[text]]></MsgType>"));
		xml.append(String.format("<Content><![CDATA[%s]]></Content>",text));
		xml.append(String.format("</xml>"));
		return xml.toString();
	}
	//单个图片
	public static String image(ws_mess mess,Image image){
		
		return null;
	}
	
	//语音
	public static String voice(){
		
		return null;
	}
	
	//多图文
	public static String images(ws_mess mess,List<Image> images){
		StringBuffer xml = new StringBuffer();
		xml.append(String.format("<xml>"));
		xml.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>",mess.getFromUserName()));
		xml.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>",mess.getToUserName()));
		xml.append(String.format("<CreateTime>%s</CreateTime>",new Date().getTime()));
		xml.append(String.format("<MsgType><![CDATA[news]]></MsgType>"));
		xml.append(String.format("<ArticleCount>%s</ArticleCount>",images.size()));
		xml.append(String.format("<Articles>"));

		for(Image image : images){
			xml.append(String.format("<item>"));
			xml.append(String.format("<Title><![CDATA[%s]]></Title> ",image.getTitle()));
			xml.append(String.format("<Description><![CDATA[%s]]></Description>",image.getDescription()));
			xml.append(String.format("<PicUrl><![CDATA[%s]]></PicUrl>",image.getPicUrl()));
			//System.out.println(xml.toString());
			//链接添加menu_id  wx_id juxinbox_app_id 并生成带时效性请求 
			String url = image.getUrl();
			url = url.replaceAll("menuid", "_menuid_");
			url = url.replaceAll("menu_id", "_menu_id_");
			url = url.replaceAll("juxinbox_app_id", "_juxinbox_app_id_");
			url = url.replaceAll("wx_id", "_wx_id_");
			
			//分解请求
			url +=((url.indexOf("?")!=-1?"&":"?") 
					+ String.format("menuid=%s&menu_id=%s&wx_id=%s&juxinbox_app_id=%s",
							mess.getMenu_id(),//兼容1.0版本
							mess.getMenu_id(),
							mess.getFromUserName(),
							mess.getApp_id()));
			xml.append(String.format("<Url><![CDATA[%s]]></Url>",url));
			
			xml.append(String.format("</item>"));
		}
	
		xml.append(String.format("</Articles>"));
		xml.append(String.format("</xml>"));
		return xml.toString();
	}
	
	//音乐
//	public static String music(ws_mess mess,music music){
//		StringBuffer xml = new StringBuffer();
//		xml.append(String.format("<xml>"));
//		xml.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>",mess.getFromUserName()));
//		xml.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>",mess.getToUserName()));
//		xml.append(String.format("<CreateTime>%s</CreateTime>",new Date().getTime()));
//		xml.append(String.format("<MsgType><![CDATA[music]]></MsgType>"));
//		xml.append(String.format("<Music>"));
//		xml.append(String.format("<Title><![CDATA[%s]]></Title>",music.getTitle()));
//		xml.append(String.format("<Description><![CDATA[%s]]></Description>",""));
//		xml.append(String.format("<MusicUrl><![CDATA[%s]]></MusicUrl>",music.getMusicUrl()));
//		xml.append(String.format("<HQMusicUrl><![CDATA[%s]]></HQMusicUrl>",music.getMusicUrl()));
//		xml.append(String.format("</Music>"));
//		xml.append(String.format("</xml>"));
//		return xml.toString();
//	}
	
	//多客服
	public static String moreServer(ws_mess mess){
		StringBuffer xml = new StringBuffer();
		xml.append(String.format("<xml>"));
		xml.append(String.format("<ToUserName><![CDATA[%s]]></ToUserName>",mess.getFromUserName()));
		xml.append(String.format("<FromUserName><![CDATA[%s]]></FromUserName>",mess.getToUserName()));
		xml.append(String.format("<CreateTime>%s</CreateTime>",new Date().getTime()));
		xml.append(String.format("<MsgType><![CDATA[transfer_customer_service]]></MsgType>"));
		xml.append(String.format("</xml>"));
		return xml.toString();
	}
	
}

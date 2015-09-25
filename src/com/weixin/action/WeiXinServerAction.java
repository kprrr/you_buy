package com.weixin.action;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.opensymphony.xwork2.ModelDriven;
import com.weixin.dao.WeiXinServerDao;
import com.weixin.model.ws_mess;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * 微信接口
 * @author lxj
 *
 */

@Component("wxAction")
@Scope("prototype")
public class WeiXinServerAction extends BaseAction implements ModelDriven<ws_mess>{
	private static final long serialVersionUID = -1059027124583291990L;
	public String signature;							//微信加密签名
	public String timestamp;							//时间戳
	public String nonce;								//随机数
	public String echostr;								//随机字符串
	
	@Autowired
	@Resource
	public WeiXinServerDao weiXinServerDao;
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
	//读取微信接口 wx-mess
	public void mess(){
		try {
			if(this.getRequest().getMethod().equals("POST")){
				long startTime = new Date().getTime();
				String xml = getPostXml();
				ws_mess m = readMessXml(xml);
				this.mess = m;
				if(m.getFromUserName()!=null){
					String urlName = this.getRequest().getRequestURI();
					urlName = urlName.substring(urlName.lastIndexOf("/") + 3,urlName.length());
					//logger.info("域名解析成功:" + urlName);
					String outMess = weiXinServerDao.getMess(serviceDao,urlName, m);
					this.outJson(outMess);
				}
				long endTime = new Date().getTime();
				logger.info("计算耗时:" + (endTime - startTime) + "ms");
			}else{
				this.outJson(echostr);//验证接口
			}
		} catch (Exception e) {
            e.printStackTrace();
			//this.outJson(WeiXinXml.text(mess, "未找到信息哦,您可以输入h返回到主菜单哦!"));
		}
	}

	//获取微信平台发送过来的post数据
	public String getPostXml(){
		if(this.getRequest().getMethod().equals("POST")){
			try {
				InputStream in = this.getRequest().getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
				byte[] data = new byte[500];  
				int count = -1;  
				while((count = in.read(data,0,500)) != -1)  
				outStream.write(data, 0, count);  
				 data = null;  
				       return new String(outStream.toByteArray(),"utf-8");  
			} catch (Exception e) {
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 * 读取微信发来的xml
	 * @param xml xml
	 * @return 消息对象
	 */
	private static ws_mess readMessXml(String xml){
		//System.out.println(xml);
		 Document document; 
		 ws_mess mess = new ws_mess();
		 try {
			document = DocumentHelper.parseText(xml); 
			Element root = document.getRootElement();
			//普通消息
			mess.setContent(root.elementText("Content"));
			mess.setCreateTime(root.elementText("CreateTime"));
			mess.setFromUserName(root.elementText("FromUserName"));
			mess.setMsgType(root.elementText("MsgType"));
			mess.setToUserName(root.elementText("ToUserName"));
			mess.setEvent(root.elementText("Event"));
			mess.setEventKey(root.elementText("EventKey"));
			
			//地理位置
			mess.setLocation_X(root.elementText("Location_X"));
			mess.setLocation_Y(root.elementText("Location_Y"));
			mess.setLabel(root.elementText("Label"));

            //二维码
             mess.setTicket(root.elementText("ticket"));//标示

			//图片
			mess.setPicUrl(root.elementText("PicUrl"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return mess;
	}
	
	ws_mess mess = new ws_mess();
	public ws_mess getModel() {
		return mess;
	}
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			System.out.println(new Date().getTime());
		}
	}
}

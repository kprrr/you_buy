package com.weixin.dao.imp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.front.service.UserService;
import com.util.WeiXinXml;
import com.weixin.dao.WeiXinServerDao;
import com.weixin.model.MessType;
import com.weixin.model.ws_mess;

@Component("weiXinServerDao")
@Scope("prototype")
public class WeiXinServerDaoImp extends JdbcDao implements WeiXinServerDao{
	
	public String url;
	public String getMess(UserService userService,String url, ws_mess mess) {
		this.url = url;
		String outMess = WeiXinXml.text(mess,"亲,我们正在努力的维护中,很快就回来!");
						MessType messType = MessType.valueOf(MessType.class, mess.getMsgType());
						switch (messType) {
						case event: //欢迎语
							ExecuteEvent executeEvent = new ExecuteEvent();
							outMess = executeEvent.start(userService, mess);
							break;
//						case text:	//文字
//							ExecuteText executeText = new ExecuteText();
//							outMess = executeText.start(this, mess, app);
//							break;
//						case Image:	//图片
//							ExecuteImage executeImage = new ExecuteImage();
//							outMess = executeImage.start(this, mess, app);
//							break;
						case location://坐标
							ExecuteLocation executeLocation = new ExecuteLocation();
							outMess = executeLocation.start(userService,mess);
							break;
//                        case music:
//                            break;
//                        case link://连接消息
//                        	ExecuteLink executeLink = new ExecuteLink();
//                        	outMess = executeLink.start(this, mess, app);
//                            break;
						default://暂无类型
							break;
						}

		return outMess;
	}
	
	
}

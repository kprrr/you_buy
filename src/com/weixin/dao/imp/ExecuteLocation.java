package com.weixin.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.tools.Tool;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.Common;
import com.base.JdbcDao;
import com.base.ServiceDao;
import com.front.model.wxuser;
import com.front.service.UserService;
import com.juxinbox.model.WxUserInfo;
import com.juxinbox.sdk.WeiXinSdk;
import com.util.WeiXinXml;
import com.weixin.model.ws_mess;

import net.sf.json.JSONObject;

/**
 * 处理欢迎语的
 * @author lxj
 *
 */



public class ExecuteLocation {
	
	@Autowired
	@Resource
	public UserService userService;
	
	private wxuser wxuser;
	
	//开始处理
	public String start(ServiceDao serviceDao,ws_mess mess){
		String outMess = "";
			outMess = WeiXinXml.text(mess, "欢迎关注!");
			wxuser  = new wxuser();
			wxuser.setWxId(mess.getFromUserName());
			wxuser.setWxuser_latitude(Float.valueOf(mess.getLocation_X()));
			wxuser.setWxuser_longitude(Float.valueOf(mess.getLocation_Y()));;
			try {
				outMess=serviceDao.updateObject(wxuser, wxuser.sqlUpdate(wxuser));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return outMess;
	}
	
	
}

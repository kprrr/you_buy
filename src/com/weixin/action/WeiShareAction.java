package com.weixin.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.Common;
import com.base.ServiceDao;
import com.util.Property;


@Component("weiShareAction")
@Scope("prototype")
public class WeiShareAction extends BaseAction
		 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
	@Autowired
	@Resource
	public Property property;
	 
	
	/**
	 * weiShare-getWxConfig
	 */
	public void getWxConfig(){
		property.setRealPath(this.getFilePath());
		WXShareUtil shareUtil = WXShareUtil.getInstance(Common.AppId,Common.AppSecret);
		String url = getRequest().getParameter("url");
		try {
			String config = shareUtil.genJSSDKConf(url);
			this.outJson(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

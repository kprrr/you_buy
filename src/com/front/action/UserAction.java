package com.front.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.activity;
import com.front.model.message;
import com.front.model.wxuser;
import com.front.service.UserService;
import com.opensymphony.xwork2.ModelDriven;



@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<wxuser>{
	private static final long serialVersionUID = 1L;
	wxuser wxuser = new wxuser();
	public wxuser getModel() {
		return wxuser;
	}
	
	@Autowired
	@Resource
	public UserService userService;

	@Autowired
	@Resource
	public ServiceDao serviceDao;
	

	
	/**
	 * user-toEdit
	 * @return
	 */
	public String toEdit(){
		wxuser = (com.front.model.wxuser) session.get("wxuser");
		this.setAttribute("wxuser", wxuser);
		String url = "";
		 url = "/pages/front/myEdit.jsp";
		 this.setForwardJsp(url); // 到首页
		 return FORWARD;
	}
	
	/**
	 * 
	 */
	public void queryWxuser() {
		wxuser = (wxuser) session.get("wxuser");
		wxuser = userService.queryWxuser(wxuser);
		if(wxuser != null) {
			this.outJsonSuccess(wxuser);
		}else {
			this.outJsonFail(wxuser);
		}
	}
	
	public void updateWxuser() {
		String mess = userService.updateWxuser(wxuser);
		this.outJson(mess);
	}
	
}

package com.front.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.comments;
import com.front.model.signup;
import com.front.model.wxuser;
import com.front.service.CommentService;
import com.opensymphony.xwork2.ModelDriven;



@Component("commentAction")
@Scope("prototype")
public class CommentAction extends BaseAction implements ModelDriven<comments>{
	private static final long serialVersionUID = 1L;
	comments comment = new comments();
	public comments getModel() {
		return comment;
	}
	
	@Autowired
	@Resource
	public CommentService commentService;

	@Autowired
	@Resource
	public ServiceDao serviceDao;
	

	
	/**
	 * 参与活动
	 */
	public void signUp() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		String mess = activityService.signUpActivity(activity,wxuser);
		this.outJson(mess);
	}	
	
	/**
	 * 我参与的活动查询
	 */
	public void querySigns() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<signup> list = activityService.querySigns(wxuser);
		this.outJson(list);
	}
}

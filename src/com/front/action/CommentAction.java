package com.front.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.activity;
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
	 * 到评论页面
	 * comment-index
	 * @return
	 */
	public String index() {
		String url = "";
		activity activity = (com.front.model.activity) session.get("activity");
		this.setAttribute("activity", activity);
		 url = "/pages/front/homeComment.jsp";
		 this.setForwardJsp(url); // 到首页
		 return FORWARD;
	}
	
	
	/**
	 * 
	 * comment-addComment
	 * @return currentUser
	 * 提交评论/回复
	 */
	public void addComment() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		activity activity = (com.front.model.activity) session.get("activity");
		String mess = commentService.addComment(comment,activity,wxuser);
		this.outJson(wxuser);
	}	
	
	/**
	 * comment-queryComments
	 * 查询评论/回复
	 */
	public void queryComments() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<comments> list = commentService.queryComments(comment,wxuser);
		this.outJson(list);
	}
}

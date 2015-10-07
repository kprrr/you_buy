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
import com.front.model.message;
import com.front.model.wxuser;
import com.front.service.MessageService;
import com.front.service.UserService;
import com.opensymphony.xwork2.ModelDriven;



@Component("messageAction")
@Scope("prototype")
public class MessageAction extends BaseAction implements ModelDriven<message>{
	private static final long serialVersionUID = 1L;
	message message = new message();
	public message getModel() {
		return message;
	}
	
	@Autowired
	@Resource
	public MessageService messageService;

	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
	@Autowired
	@Resource
	public UserService userService;
	
	
	/**
	 * 到消息页面
	 * message-index
	 * @param sender_id
	 * @return
	 */
	public String index() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		this.setAttribute("me_photo", wxuser.getPhoto());
		wxuser sender = new wxuser();
		sender.setId(message.getSender_id());
		sender = userService.queryWxuser(sender);
		this.setAttribute("sender", sender);
		
		String url = "";
		 url = "/pages/front/myDialog.jsp";
		 this.setForwardJsp(url); // 到首页
		 return FORWARD;
	}
	
	/**
	 * 发消息
	 *  1.系统消息默认在初始化数据库时插入一条系统wxuser数据
	 *  2.前台从页面上获得receiver的id和头像,sender的id和头像由session里的wxuser获得
	 *  message-addMsg
	 */
	public void addMsg() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		String mess = messageService.addMsg(message,wxuser);
		this.outJson(mess);
	}	
	
	/**
	 * message-queryMsgWithTime
	 * 查询消息列表首页 index_msg
	 */
	public void queryMsgWithTime() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<message> list = messageService.queryMsgWithTime(message,wxuser);
		this.outJson(list);
	}
	
	
	/**
	 * 查询评论/回复
	 */
	public void queryMsg() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<message> list = messageService.queryMsg(message,wxuser);
		this.outJson(list);
	}
	
}

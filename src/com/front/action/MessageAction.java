package com.front.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.comments;
import com.front.model.message;
import com.front.model.wxuser;
import com.front.service.MessageService;
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
	

	
	/**
	 * 发消息
	 *  1.系统消息默认在初始化数据库时插入一条系统wxuser数据
	 *  2.前台从页面上获得receiver的id和头像,sender的id和头像由session里的wxuser获得
	 */
	public void addMsg() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		String mess = messageService.addMsg(message,wxuser);
		this.outJson(mess);
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

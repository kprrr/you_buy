package com.front.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseService;
import com.base.Constant;
import com.base.JdbcDao;
import com.base.ServiceDao;
import com.front.model.comments;
import com.front.model.message;
import com.front.model.wxuser;
import com.test.MessageTime;


@Component("messageService")
@Scope("prototype")
public class MessageService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;

	public String addMsg(message msg, wxuser wxuser) {
		// TODO Auto-generated method stub
		msg.setSender_id(wxuser.getId());
		msg.setSender_photo(wxuser.getPhoto());
		msg.setIsread(Constant.NOT_READ);
		msg.setId(JdbcDao.createKey());
		msg.setIsdelete(1);
		String mess = "";
		try {
			mess = serviceDao.addObject(msg, sqlInsertName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mess;
	}

	public List<message> queryMsgWithTime(message message, wxuser wxuser) {
		// TODO Auto-generated method stub
		List<message> list = serviceDao.getList(message, "sqlSelectDistinct");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(int i =0;i<list.size();i++) {
			message msg = list.get(i);
			try {
				msg.setTimeFlag(MessageTime.showTime(df.parse(msg.getCreatetime()), null));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return list;
	}
	
	
	public List<message> queryMsg(message message, wxuser wxuser) {
		// TODO Auto-generated method stub
		List<message> list = serviceDao.getList(message, sqlSelectName);
		return list;
	}
	
}

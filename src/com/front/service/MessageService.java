package com.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.BaseService;
import com.base.JdbcDao;
import com.base.ServiceDao;
import com.front.model.comments;
import com.front.model.message;
import com.front.model.wxuser;

public class MessageService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;

	public String addMsg(message msg, wxuser wxuser) {
		// TODO Auto-generated method stub
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


	public List<message> queryMsg(message message, wxuser wxuser) {
		// TODO Auto-generated method stub
		List<message> list = serviceDao.getList(message, message.sqlSelect(message));
		return list;
	}
	
}

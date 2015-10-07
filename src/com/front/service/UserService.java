package com.front.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseService;
import com.base.JdbcDao;
import com.base.ServiceDao;
import com.front.model.comments;
import com.front.model.message;
import com.front.model.wxuser;
import com.mysql.jdbc.JDBC4CallableStatement;
import com.weixin.model.ws_mess;


@Component("userService")
@Scope("prototype")
public class UserService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;

	public String addWxuser(wxuser wxuser) {
		// TODO Auto-generated method stub
		wxuser.setId(JdbcDao.createKey());
		wxuser.setIsdelete(1);
		String mess = "";
		try {
			mess = serviceDao.addObject(wxuser, sqlInsertName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mess;
	}
	public wxuser queryWxuser( wxuser wxuser) {
		// TODO Auto-generated method stub
		List<wxuser> list = serviceDao.getList(wxuser, sqlSelectName);
		if(list != null && list.size() == 1){
			return list.get(0);
		}
			return null;
	}

	public List<wxuser> queryWxuserList( wxuser wxuser) {
		// TODO Auto-generated method stub
		List<wxuser> list = serviceDao.getList(wxuser, wxuser.sqlSelect(wxuser));
		return list;
	}
	
	public String updateWxuser( wxuser wxuser) {
		// TODO Auto-generated method stub
		String mess = "";
		synchronized (wxuser) {
			try {
				mess = serviceDao.updateObject(wxuser, wxuser.sqlUpdate(wxuser));
				return mess;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return null;
	}


	
}

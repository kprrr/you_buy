package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.UserDao;
import com.user.model.user;

@Component("userDao")
@Scope("prototype")
public class UserDaoImp extends JdbcDao implements UserDao{

	public PageList getUser(user user, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = user.sqlSelect(user);
		int counts = this.getCount(sql, user);
		pl.setTotal(counts);
		
		List<user> list;
		if(pageSize!=null){
			list = this.selectSql(sql, user, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, user);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addUser(user user) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(user, user.sqlInsert())){
			outMess = this.codeMess(eCode, "对应用户已存在!");
		}
		return outMess;
	}

	public String deleteUser(user user) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(user, user.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateUser(user user) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(user, user.sqlUpdate(user))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

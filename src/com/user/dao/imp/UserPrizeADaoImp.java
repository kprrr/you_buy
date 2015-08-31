package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.UserPrizeADao;
import com.user.model.user_prize_a;

@Component("userPrizeADao")
@Scope("prototype")
public class UserPrizeADaoImp extends JdbcDao implements UserPrizeADao{

	public PageList getUserPrizeA(user_prize_a userPrizeA, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = userPrizeA.sqlSelect(userPrizeA);
		int counts = this.getCount(sql, userPrizeA);
		pl.setTotal(counts);
		
		List<user_prize_a> list;
		if(pageSize!=null){
			list = this.selectSql(sql, userPrizeA, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, userPrizeA);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addUserPrizeA(user_prize_a userPrizeA) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(userPrizeA, userPrizeA.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteUserPrizeA(user_prize_a userPrizeA) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(userPrizeA, userPrizeA.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateUserPrizeA(user_prize_a userPrizeA) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(userPrizeA, userPrizeA.sqlUpdate(userPrizeA))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

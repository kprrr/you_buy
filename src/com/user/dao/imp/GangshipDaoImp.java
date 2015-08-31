package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangshipDao;
import com.user.model.gangship;

@Component("gangshipDao")
@Scope("prototype")
public class GangshipDaoImp extends JdbcDao implements GangshipDao{

	public PageList getGangship(gangship gangship, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangship.sqlSelect(gangship);
		int counts = this.getCount(sql, gangship);
		pl.setTotal(counts);
		
		List<gangship> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangship, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangship);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangship(gangship gangship) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangship, gangship.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangship(gangship gangship) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangship, gangship.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangship(gangship gangship) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangship, gangship.sqlUpdate(gangship))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangWarDao;
import com.user.model.gang_war;

@Component("gangWarDao")
@Scope("prototype")
public class GangWarDaoImp extends JdbcDao implements GangWarDao{

	public PageList getGangWar(gang_war gangWar, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangWar.sqlSelect(gangWar);
		int counts = this.getCount(sql, gangWar);
		pl.setTotal(counts);
		
		List<gang_war> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangWar, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangWar);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangWar(gang_war gangWar) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWar, gangWar.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangWar(gang_war gangWar) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWar, gangWar.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangWar(gang_war gangWar) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWar, gangWar.sqlUpdate(gangWar))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

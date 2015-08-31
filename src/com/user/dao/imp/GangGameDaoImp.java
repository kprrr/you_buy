package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangGameDao;
import com.user.model.gang_game;

@Component("gangGameDao")
@Scope("prototype")
public class GangGameDaoImp extends JdbcDao implements GangGameDao{

	public PageList getGangGame(gang_game gangGame, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangGame.sqlSelect(gangGame);
		int counts = this.getCount(sql, gangGame);
		pl.setTotal(counts);
		
		List<gang_game> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangGame, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangGame);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangGame(gang_game gangGame) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGame, gangGame.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangGame(gang_game gangGame) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGame, gangGame.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangGame(gang_game gangGame) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGame, gangGame.sqlUpdate(gangGame))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

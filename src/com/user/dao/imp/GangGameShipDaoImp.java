package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangGameShipDao;
import com.user.model.gang_game_ship;

@Component("gangGameShipDao")
@Scope("prototype")
public class GangGameShipDaoImp extends JdbcDao implements GangGameShipDao{

	public PageList getGangGameShip(gang_game_ship gangGameShip, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangGameShip.sqlSelect(gangGameShip);
		int counts = this.getCount(sql, gangGameShip);
		pl.setTotal(counts);
		
		List<gang_game_ship> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangGameShip, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangGameShip);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangGameShip(gang_game_ship gangGameShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGameShip, gangGameShip.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangGameShip(gang_game_ship gangGameShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGameShip, gangGameShip.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangGameShip(gang_game_ship gangGameShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangGameShip, gangGameShip.sqlUpdate(gangGameShip))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

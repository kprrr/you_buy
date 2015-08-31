package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangArtiShipDao;
import com.user.model.gang_arti_ship;

@Component("gangArtiShipDao")
@Scope("prototype")
public class GangArtiShipDaoImp extends JdbcDao implements GangArtiShipDao{

	public PageList getGangArtiShip(gang_arti_ship gangArtiShip, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangArtiShip.sqlSelect(gangArtiShip);
		int counts = this.getCount(sql, gangArtiShip);
		pl.setTotal(counts);
		
		List<gang_arti_ship> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangArtiShip, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangArtiShip);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangArtiShip(gang_arti_ship gangArtiShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArtiShip, gangArtiShip.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangArtiShip(gang_arti_ship gangArtiShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArtiShip, gangArtiShip.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangArtiShip(gang_arti_ship gangArtiShip) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArtiShip, gangArtiShip.sqlUpdate(gangArtiShip))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

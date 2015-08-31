package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangArtiDao;
import com.user.model.gang_arti;

@Component("gangArtiDao")
@Scope("prototype")
public class GangArtiDaoImp extends JdbcDao implements GangArtiDao{

	public PageList getGangArti(gang_arti gangArti, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangArti.sqlSelect(gangArti);
		int counts = this.getCount(sql, gangArti);
		pl.setTotal(counts);
		
		List<gang_arti> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangArti, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangArti);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangArti(gang_arti gangArti) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArti, gangArti.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangArti(gang_arti gangArti) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArti, gangArti.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangArti(gang_arti gangArti) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangArti, gangArti.sqlUpdate(gangArti))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

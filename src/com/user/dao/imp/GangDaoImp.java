package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangDao;
import com.user.model.gang;

@Component("gangDao")
@Scope("prototype")
public class GangDaoImp extends JdbcDao implements GangDao{

	public PageList getGang(gang gang, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gang.sqlSelect(gang);
		int counts = this.getCount(sql, gang);
		pl.setTotal(counts);
		
		List<gang> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gang, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gang);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGang(gang gang) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gang, gang.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGang(gang gang) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gang, gang.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGang(gang gang) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gang, gang.sqlUpdate(gang))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

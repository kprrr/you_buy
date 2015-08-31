package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangWarInfoDao;
import com.user.model.gang_war_info;

@Component("gangWarInfoDao")
@Scope("prototype")
public class GangWarInfoDaoImp extends JdbcDao implements GangWarInfoDao{

	public PageList getGangWarInfo(gang_war_info gangWarInfo, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangWarInfo.sqlSelect(gangWarInfo);
		int counts = this.getCount(sql, gangWarInfo);
		pl.setTotal(counts);
		
		List<gang_war_info> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangWarInfo, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangWarInfo);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangWarInfo(gang_war_info gangWarInfo) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWarInfo, gangWarInfo.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangWarInfo(gang_war_info gangWarInfo) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWarInfo, gangWarInfo.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangWarInfo(gang_war_info gangWarInfo) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangWarInfo, gangWarInfo.sqlUpdate(gangWarInfo))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

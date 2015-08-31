package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.GangTaskDao;
import com.user.model.gang_task;

@Component("gangTaskDao")
@Scope("prototype")
public class GangTaskDaoImp extends JdbcDao implements GangTaskDao{

	public PageList getGangTask(gang_task gangTask, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = gangTask.sqlSelect(gangTask);
		int counts = this.getCount(sql, gangTask);
		pl.setTotal(counts);
		
		List<gang_task> list;
		if(pageSize!=null){
			list = this.selectSql(sql, gangTask, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, gangTask);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addGangTask(gang_task gangTask) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangTask, gangTask.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteGangTask(gang_task gangTask) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangTask, gangTask.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateGangTask(gang_task gangTask) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(gangTask, gangTask.sqlUpdate(gangTask))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

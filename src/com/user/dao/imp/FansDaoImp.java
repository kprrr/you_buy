package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.FansDao;
import com.user.model.fans;

@Component("fansDao")
@Scope("prototype")
public class FansDaoImp extends JdbcDao implements FansDao{

	public PageList getFans(fans fans, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = fans.sqlSelect(fans);
		int counts = this.getCount(sql, fans);
		pl.setTotal(counts);
		
		List<fans> list;
		if(pageSize!=null){
			list = this.selectSql(sql, fans, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, fans);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addFans(fans fans) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(fans, fans.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteFans(fans fans) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(fans, fans.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateFans(fans fans) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(fans, fans.sqlUpdate(fans))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

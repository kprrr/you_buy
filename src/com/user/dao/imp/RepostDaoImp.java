package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.RepostDao;
import com.user.model.repost;

@Component("repostDao")
@Scope("prototype")
public class RepostDaoImp extends JdbcDao implements RepostDao{

	public PageList getRepost(repost repost, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = repost.sqlSelect(repost);
		int counts = this.getCount(sql, repost);
		pl.setTotal(counts);
		
		List<repost> list;
		if(pageSize!=null){
			list = this.selectSql(sql, repost, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, repost);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addRepost(repost repost) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(repost, repost.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteRepost(repost repost) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(repost, repost.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateRepost(repost repost) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(repost, repost.sqlUpdate(repost))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

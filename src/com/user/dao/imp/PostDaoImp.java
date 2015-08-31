package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.PostDao;
import com.user.model.post;

@Component("postDao")
@Scope("prototype")
public class PostDaoImp extends JdbcDao implements PostDao{

	public PageList getPost(post post, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = post.sqlSelect(post);
		int counts = this.getCount(sql, post);
		pl.setTotal(counts);
		
		List<post> list;
		if(pageSize!=null){
			list = this.selectSql(sql, post, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, post);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addPost(post post) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(post, post.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deletePost(post post) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(post, post.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updatePost(post post) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(post, post.sqlUpdate(post))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}

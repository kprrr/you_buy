package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.PostDao;
import com.user.model.post;
import com.opensymphony.xwork2.ModelDriven;

/**
 * post请求处理
 * 
 * @author 张宏
 * 
 */
@Component("postAction")
@Scope("prototype")
public class PostAction extends BaseAction implements ModelDriven<post> {

	@Autowired
	@Resource
	public PostDao postDao;

	// 获取post-get
	public void get() {
		PageList pageList = postDao.getPost(post, rows, page);

		this.outJson(pageList);
	}

	// 添加post-insert
	public void insert() {
		//post.setCategory(1);// 秘籍
		String outMess = postDao.addPost(post);
		this.outJson(outMess);
	}

	// 删除post-remove
	public void remove() {
		String outMess = postDao.deletePost(post);
		this.outJson(outMess);
	}

	// 修改post-update
	public void update() {
		String outMess = postDao.updatePost(post);
		this.outJson(outMess);
	}

	post post = new post();

	public post getModel() {
		// TODO Auto-generated method stub
		return post;
	}
}

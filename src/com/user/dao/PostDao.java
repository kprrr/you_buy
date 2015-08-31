package com.user.dao;

import com.base.PageList;
import com.user.model.post;

public interface PostDao {
	
	/**
	 * 获取post列表
	 * @param post
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getPost(post post,String pageSize,String pageNo);
	
	/**
	 * 添加post
	 * @param post
	 * @return
	 */
	public String addPost(post post);
	
	/**
	 * 修改post
	 * @param post
	 * @return
	 */
	public String updatePost(post post);
	
	/**
	 * 删除post
	 * @param post
	 * @return
	 */
	public String deletePost(post post);
	
}

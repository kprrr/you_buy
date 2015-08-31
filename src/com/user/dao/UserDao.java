package com.user.dao;

import com.base.PageList;
import com.user.model.user;

public interface UserDao {
	
	/**
	 * 获取user列表
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getUser(user user,String pageSize,String pageNo);
	
	/**
	 * 添加user
	 * @param user
	 * @return
	 */
	public String addUser(user user);
	
	/**
	 * 修改user
	 * @param user
	 * @return
	 */
	public String updateUser(user user);
	
	/**
	 * 删除user
	 * @param user
	 * @return
	 */
	public String deleteUser(user user);
	
}

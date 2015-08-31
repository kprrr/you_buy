package com.user.dao;

import com.base.PageList;
import com.user.model.gangship;

public interface GangshipDao {
	
	/**
	 * 获取gangship列表
	 * @param gangship
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangship(gangship gangship,String pageSize,String pageNo);
	
	/**
	 * 添加gangship
	 * @param gangship
	 * @return
	 */
	public String addGangship(gangship gangship);
	
	/**
	 * 修改gangship
	 * @param gangship
	 * @return
	 */
	public String updateGangship(gangship gangship);
	
	/**
	 * 删除gangship
	 * @param gangship
	 * @return
	 */
	public String deleteGangship(gangship gangship);
	
}

package com.user.dao;

import com.base.PageList;
import com.user.model.fans;

public interface FansDao {
	
	/**
	 * 获取fans列表
	 * @param fans
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getFans(fans fans,String pageSize,String pageNo);
	
	/**
	 * 添加fans
	 * @param fans
	 * @return
	 */
	public String addFans(fans fans);
	
	/**
	 * 修改fans
	 * @param fans
	 * @return
	 */
	public String updateFans(fans fans);
	
	/**
	 * 删除fans
	 * @param fans
	 * @return
	 */
	public String deleteFans(fans fans);
	
}

package com.user.dao;

import com.base.PageList;
import com.user.model.gang;

public interface GangDao {
	
	/**
	 * 获取gang列表
	 * @param gang
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGang(gang gang,String pageSize,String pageNo);
	
	/**
	 * 添加gang
	 * @param gang
	 * @return
	 */
	public String addGang(gang gang);
	
	/**
	 * 修改gang
	 * @param gang
	 * @return
	 */
	public String updateGang(gang gang);
	
	/**
	 * 删除gang
	 * @param gang
	 * @return
	 */
	public String deleteGang(gang gang);
	
}

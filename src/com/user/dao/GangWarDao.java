package com.user.dao;

import com.base.PageList;
import com.user.model.gang_war;

public interface GangWarDao {
	
	/**
	 * 获取gang_war列表
	 * @param gang_war
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangWar(gang_war gangWar,String pageSize,String pageNo);
	
	/**
	 * 添加gang_war
	 * @param gang_war
	 * @return
	 */
	public String addGangWar(gang_war gangWar);
	
	/**
	 * 修改gang_war
	 * @param gang_war
	 * @return
	 */
	public String updateGangWar(gang_war gangWar);
	
	/**
	 * 删除gang_war
	 * @param gang_war
	 * @return
	 */
	public String deleteGangWar(gang_war gangWar);
	
}

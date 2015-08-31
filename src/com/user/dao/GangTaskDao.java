package com.user.dao;

import com.base.PageList;
import com.user.model.gang_task;

public interface GangTaskDao {
	
	/**
	 * 获取gang_task列表
	 * @param gang_task
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangTask(gang_task gangTask,String pageSize,String pageNo);
	
	/**
	 * 添加gang_task
	 * @param gang_task
	 * @return
	 */
	public String addGangTask(gang_task gangTask);
	
	/**
	 * 修改gang_task
	 * @param gang_task
	 * @return
	 */
	public String updateGangTask(gang_task gangTask);
	
	/**
	 * 删除gang_task
	 * @param gang_task
	 * @return
	 */
	public String deleteGangTask(gang_task gangTask);
	
}

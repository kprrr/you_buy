package com.user.dao;

import com.base.PageList;
import com.user.model.gang_game;

public interface GangGameDao {
	
	/**
	 * 获取gang_game列表
	 * @param gang_game
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangGame(gang_game gangGame,String pageSize,String pageNo);
	
	/**
	 * 添加gang_game
	 * @param gang_game
	 * @return
	 */
	public String addGangGame(gang_game gangGame);
	
	/**
	 * 修改gang_game
	 * @param gang_game
	 * @return
	 */
	public String updateGangGame(gang_game gangGame);
	
	/**
	 * 删除gang_game
	 * @param gang_game
	 * @return
	 */
	public String deleteGangGame(gang_game gangGame);
	
}

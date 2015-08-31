package com.user.dao;

import com.base.PageList;
import com.user.model.gang_game_ship;

public interface GangGameShipDao {
	
	/**
	 * 获取gang_game_ship列表
	 * @param gang_game_ship
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangGameShip(gang_game_ship gangGameShip,String pageSize,String pageNo);
	
	/**
	 * 添加gang_game_ship
	 * @param gang_game_ship
	 * @return
	 */
	public String addGangGameShip(gang_game_ship gangGameShip);
	
	/**
	 * 修改gang_game_ship
	 * @param gang_game_ship
	 * @return
	 */
	public String updateGangGameShip(gang_game_ship gangGameShip);
	
	/**
	 * 删除gang_game_ship
	 * @param gang_game_ship
	 * @return
	 */
	public String deleteGangGameShip(gang_game_ship gangGameShip);
	
}

package com.user.dao;

import com.base.PageList;
import com.user.model.user_prize_a;

public interface UserPrizeADao {
	
	/**
	 * 获取user_prize_a列表
	 * @param user_prize_a
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getUserPrizeA(user_prize_a userPrizeA,String pageSize,String pageNo);
	
	/**
	 * 添加user_prize_a
	 * @param user_prize_a
	 * @return
	 */
	public String addUserPrizeA(user_prize_a userPrizeA);
	
	/**
	 * 修改user_prize_a
	 * @param user_prize_a
	 * @return
	 */
	public String updateUserPrizeA(user_prize_a userPrizeA);
	
	/**
	 * 删除user_prize_a
	 * @param user_prize_a
	 * @return
	 */
	public String deleteUserPrizeA(user_prize_a userPrizeA);
	
}

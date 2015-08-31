package com.user.dao;

import com.base.PageList;
import com.user.model.repost;

public interface RepostDao {
	
	/**
	 * 获取repost列表
	 * @param repost
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getRepost(repost repost,String pageSize,String pageNo);
	
	/**
	 * 添加repost
	 * @param repost
	 * @return
	 */
	public String addRepost(repost repost);
	
	/**
	 * 修改repost
	 * @param repost
	 * @return
	 */
	public String updateRepost(repost repost);
	
	/**
	 * 删除repost
	 * @param repost
	 * @return
	 */
	public String deleteRepost(repost repost);
	
}

package com.user.dao;

import com.base.PageList;
import com.user.model.score_record;

public interface ScoreRecordDao {

	/**
	 * 获取score_record列表
	 * 
	 * @param score_record
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getScoreRecord(score_record scoreRecord, String pageSize,
			String pageNo);

	/**
	 * 添加score_record
	 * 
	 * @param score_record
	 * @return
	 */
	public String addScoreRecord(score_record scoreRecord);

	/**
	 * 修改score_record
	 * 
	 * @param score_record
	 * @return
	 */
	public String updateScoreRecord(score_record scoreRecord);

	/**
	 * 删除score_record
	 * 
	 * @param score_record
	 * @return
	 */
	public String deleteScoreRecord(score_record scoreRecord);

	public String getSumScore(score_record scoreRecord);

}

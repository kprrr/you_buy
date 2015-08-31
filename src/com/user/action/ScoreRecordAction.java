package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.ScoreRecordDao;
import com.user.model.score_record;
import com.opensymphony.xwork2.ModelDriven;

/**
 * score_record请求处理
 * 
 * @author 张宏
 * 
 */
@Component("scoreRecordAction")
@Scope("prototype")
public class ScoreRecordAction extends BaseAction implements
		ModelDriven<score_record> {

	@Autowired
	@Resource
	public ScoreRecordDao scoreRecordDao;

	// 获取scoreRecord-get
	public void get() {
		PageList pageList = scoreRecordDao.getScoreRecord(scoreRecord, rows,
				page);
		this.outJson(pageList);
	}

	// 获取scoreRecord-getSumScore
	public void getSumScore() {
		String mess = scoreRecordDao.getSumScore(scoreRecord);
		this.outJson(mess);
	}

	// 添加scoreRecord-insert
	public void insert() {
		String outMess = scoreRecordDao.addScoreRecord(scoreRecord);
		this.outJson(outMess);
	}

	// 删除scoreRecord-remove
	public void remove() {
		String outMess = scoreRecordDao.deleteScoreRecord(scoreRecord);
		this.outJson(outMess);
	}

	// 修改scoreRecord-update
	public void update() {
		String outMess = scoreRecordDao.updateScoreRecord(scoreRecord);
		this.outJson(outMess);
	}

	score_record scoreRecord = new score_record();

	public score_record getModel() {
		// TODO Auto-generated method stub
		return scoreRecord;
	}
}

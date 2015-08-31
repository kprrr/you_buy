package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.ScoreRecordDao;
import com.user.model.score_record;

@Component("scoreRecordDao")
@Scope("prototype")
public class ScoreRecordDaoImp extends JdbcDao implements ScoreRecordDao {

	public PageList getScoreRecord(score_record scoreRecord, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = scoreRecord.sqlSelect(scoreRecord);
		int counts = this.getCount(sql, scoreRecord);
		pl.setTotal(counts);

		List<score_record> list;
		if (pageSize != null) {
			list = this.selectSql(sql, scoreRecord, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		} else {
			list = this.selectSql(sql, scoreRecord);
		}
		pl.setRows(list);
		return pl;
	}

	public String addScoreRecord(score_record scoreRecord) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if (!this.executeSql(scoreRecord, scoreRecord.sqlInsert())) {
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteScoreRecord(score_record scoreRecord) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if (!this.executeSql(scoreRecord, scoreRecord.sqlDelete())) {
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateScoreRecord(score_record scoreRecord) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if (!this.executeSql(scoreRecord, scoreRecord.sqlUpdate(scoreRecord))) {
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

	public String getSumScore(score_record scoreRecord) {
		// TODO Auto-generated method stub

		List<score_record> list = this.selectSql(scoreRecord
				.sqlSelectSum(scoreRecord), scoreRecord);

		String sum = list.get(0).getSum_score();
		sum = sum == null ? "0" : sum;
		String mess = codeJson(sCode, sum);

		return mess;
	}
}

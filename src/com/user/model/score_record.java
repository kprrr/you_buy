package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * score_record
 * 
 * @author 张宏
 * 
 */
public class score_record extends BaseModel implements Serializable {

	private Integer id;//
	private Integer uid;// 用户id
	private Integer score;// 积分数
	private String info;// 兑换信息
	private String timestamp;// 兑换时间

	private Integer type;// 类型

	private String attach_name;// 用户昵称
	private String icon;// 用户头像

	private String strarTime;
	private String endTime;
	private String type2;// 分类

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getStrarTime() {
		return strarTime;
	}

	public void setStrarTime(String strarTime) {
		this.strarTime = strarTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attachName) {
		attach_name = attachName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into score_record ");
		sql.append("(id, uid, score, info, timestamp) ");
		sql.append("values ");
		sql.append("(:id, :uid, :score, :info, :timestamp) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from score_record ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(score_record scoreRecord) {
		StringBuffer sql = new StringBuffer();
		sql.append("select sr.id, sr.uid, sr.score, sr.info, sr.timestamp,");
		sql.append("u.name as attach_name,u.icon as icon ");
		sql.append("from score_record sr ");
		sql.append("left join user u on sr.uid = u.id ");
		sql.append(" where 1 = 1 ");

		if (scoreRecord.getId() != null) {
			sql.append("and sr.id = :id ");
		}
		if (scoreRecord.getUid() != null) {
			sql.append("and sr.uid = :uid ");
		}
		if (scoreRecord.getInfo() != null && scoreRecord.getInfo().length() > 0) {
			scoreRecord.setInfo("%" + scoreRecord.getInfo() + "%");
			sql.append("and info like :info ");
		}
		if (scoreRecord.getStrarTime() != null
				&& scoreRecord.getStrarTime().length() > 0) {
			sql.append("and `timestamp`>=:strarTime ");
		}
		if (scoreRecord.getEndTime() != null
				&& scoreRecord.getEndTime().length() > 0) {
			sql.append("and `timestamp`<=:endTime ");
		}
		if (scoreRecord.getType2() != null
				&& scoreRecord.getType2().length() > 0) {
			scoreRecord.setType2("%" + scoreRecord.getType2() + "%");
			sql.append("and type2 like :type2 ");

		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(score_record scoreRecord) {
		StringBuffer sql = new StringBuffer();
		sql.append("update score_record ");

		sql.append("set id = :id");
		if (scoreRecord.getUid() != null) {
			sql.append(",uid = :uid");
		}
		if (scoreRecord.getScore() != null) {
			sql.append(",score = :score");
		}
		if (scoreRecord.getInfo() != null && scoreRecord.getInfo().length() > 0) {
			sql.append(",info = :info");
		}
		if (scoreRecord.getTimestamp() != null
				&& scoreRecord.getTimestamp().length() > 0) {
			sql.append(",timestamp = :timestamp");
		}

		sql.append(" where id = :id ");

		return sql.toString();
	}

	private String sum_score;// 总积分

	public String getSum_score() {
		return sum_score;
	}

	public void setSum_score(String sumScore) {
		sum_score = sumScore;
	}

	// 生成查询语句
	public String sqlSelectSum(score_record scoreRecord) {
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(sr.score) as sum_score ");
		sql.append("from score_record sr ");
		sql.append("left join user u on sr.uid = u.id ");
		sql.append(" where 1 = 1 ");

		if (scoreRecord.getId() != null) {
			sql.append("and sr.id = :id ");
		}
		if (scoreRecord.getUid() != null) {
			sql.append("and sr.uid = :uid ");
		}
		if (scoreRecord.getStrarTime() != null
				&& scoreRecord.getStrarTime().length() > 0) {
			sql.append("and `timestamp`>=:strarTime ");
		}
		if (scoreRecord.getEndTime() != null
				&& scoreRecord.getEndTime().length() > 0) {
			sql.append("and `timestamp`<=:endTime ");
		}

		if (scoreRecord.getInfo() != null && scoreRecord.getInfo().length() > 0) {
			scoreRecord.setInfo("%" + scoreRecord.getInfo() + "%");
			sql.append("and info like :info ");
		}
		return sql.toString();
	}
}

package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * user_prize_a
 * 
 * @author 张宏
 * 
 */
public class user_prize_a extends BaseModel implements Serializable {

	private Integer uid;//
	private String prize_code;// 奖券兑换号号
	private String prize;// 奖品信息
	private Integer got;// 是否领取 ：1 领取 0 未领取
	private String timestamp;// 获取时间
	private String info;// 获取奖品信息

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPrize_code() {
		return prize_code;
	}

	public void setPrize_code(String prize_code) {
		this.prize_code = prize_code;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Integer getGot() {
		return got;
	}

	public void setGot(Integer got) {
		this.got = got;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into user_prize_a ");
		sql.append("(uid, prize_code, prize, got, timestamp, info) ");
		sql.append("values ");
		sql.append("(:uid, :prize_code, :prize, :got, :timestamp, :info) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from user_prize_a ");
		sql.append("where uid = :uid ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(user_prize_a userPrizeA) {
		StringBuffer sql = new StringBuffer();
		sql.append("select uid, prize_code, prize, got, timestamp, info ");
		sql.append("from user_prize_a where 0 = 0 ");

		if (isNotNull(userPrizeA.getUid())) {
			sql.append("and uid = :uid ");
		}
		if (isNotNull(userPrizeA.getPrize_code())) {
			userPrizeA.setPrize_code("%" + userPrizeA.getPrize_code() + "%");
			sql.append("and prize_code like :prize_code ");
		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(user_prize_a userPrizeA) {
		StringBuffer sql = new StringBuffer();
		sql.append("update user_prize_a ");

		sql.append("set uid = :uid");
		if (isNotNull(userPrizeA.getPrize_code())) {
			sql.append(",prize_code = :prize_code");
		}
		if (isNotNull(userPrizeA.getPrize())) {
			sql.append(",prize = :prize");
		}
		if (isNotNull(userPrizeA.getGot())) {
			sql.append(",got = :got");
		}
		if (isNotNull(userPrizeA.getTimestamp())) {
			sql.append(",timestamp = :timestamp");
		}
		if (isNotNull(userPrizeA.getInfo())) {
			sql.append(",info = :info");
		}

		sql.append(" where uid = :uid ");

		return sql.toString();
	}

}

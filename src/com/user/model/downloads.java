package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * downloads
 * @author 张宏
 *
 */
public class downloads extends BaseModel implements Serializable{

	private Integer id;//
	private Integer apk;//
    private Integer ipa;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getApk() {
        return apk;
    }

    public void setApk(Integer apk) {
        this.apk = apk;
    }

    public Integer getIpa() {
        return ipa;
    }

    public void setIpa(Integer ipa) {
        this.ipa = ipa;
    }

    //生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into downloads ");
		sql.append("(id, downloads_count) ");
		sql.append("values ");
		sql.append("(:id, :downloads_count) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from downloads ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(downloads downloads){
		StringBuffer sql = new StringBuffer();
		sql.append("select * ");
		sql.append("from downloads where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(downloads downloads){
		StringBuffer sql = new StringBuffer();
		sql.append("update downloads ");
		
		sql.append("set id = :id");
		if(downloads.getApk()!=null){
			sql.append(",apk = :apk");
		}
        if(downloads.getIpa()!=null){
            sql.append(",ipa = :ipa");
        }
		
		return sql.toString();
	}

}

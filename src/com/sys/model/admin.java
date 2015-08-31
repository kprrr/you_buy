package com.sys.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * user
 *
 * @author 张宏
 */
public class admin extends BaseModel implements Serializable {

    private Integer id;//
    private String name;//
    private String password;//
    private int isdelete;



    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	// 生成添加语句
    public String sqlInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into user ");
        sql
                .append("(id, `name`, password, male, age, `mobile`, score, icon, addtime,apk,ipa) ");
        sql.append("values ");
        sql
                .append("(:id, :name, :password, :male, :age, :mobile, :score, :icon, :addtime,:apk,:ipa) ");
        return sql.toString();
    }

    // 生成删除语句
    public String sqlDelete() {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from user ");
        sql.append("where id = :id ");
        return sql.toString();
    }

    // 生成查询语句
    public String sqlSelect(admin user) {
        StringBuffer sql = new StringBuffer();
        sql
                .append("select a.* ");
        sql.append("from admin a ");


        sql.append("where 1 = 1 and name is not null ");
        if (user.getId() != null) {
            sql.append("and u.id = :id ");
        }
        if (user.getPassword() != null) {
            sql.append("and u.password = :password ");
        }
        
        return sql.toString();
    }

    // 生成修改语句
    public String sqlUpdate(admin user) {
        StringBuffer sql = new StringBuffer();
        sql.append("update user ");

        sql.append("set id = :id");
        if (user.getName() != null && user.getName().length() > 0) {
            sql.append(",`name` = :name");
        }
        if (user.getPassword() != null && user.getPassword().length() > 0) {
            sql.append(",password = :password");
        }
       
        sql.append(",apk = :apk ,ipa=:ipa ");

        sql.append(" where id = :id");

        return sql.toString();
    }

}

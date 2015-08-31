package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * user
 *
 * @author 张宏
 */
public class sites extends BaseModel implements Serializable {

    private String id;//
    private String name;//
    private Integer type;
    private String	img;
    private Integer	price;
    private String	place;
    private String	region_id;
    private String	tel;
    private Float Longitude;	
    private Float Latitude;
    private String	createtime;
    private int isdelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Float getLongitude() {
		return Longitude;
	}

	public void setLongitude(Float longitude) {
		Longitude = longitude;
	}

	public Float getLatitude() {
		return Latitude;
	}

	public void setLatitude(Float latitude) {
		Latitude = latitude;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
        sql.append("insert into sites ");
        sql
                .append("(id, name, type, img, price, place, region_id, tel, Longitude,Latitude,createtime,isdetele) ");
        sql.append("values ");
        sql
                .append("(:id, :name, :type, :img, :price, :place, :region_id, :tel, :Longitude,:Latitude,CURRENT_TIMESTAMP,:isdetele) ");
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
    public String sqlSelect(sites user) {
        StringBuffer sql = new StringBuffer();
        sql
                .append("select u.* ");
        sql.append("from user u ");


        sql.append("where 1 = 1 and name is not null ");
        if (user.getId() != null) {
            sql.append("and u.id = :id ");
        }
        if (user.getName() != null && user.getName().length() > 0) {
            user.setName("%" + user.getName() + "%");
            sql.append("and u.name like :name ");
        }
        sql.append("  order by u.addtime ");
        return sql.toString();
    }

    // 生成修改语句
    public String sqlUpdate(sites user) {
        StringBuffer sql = new StringBuffer();
        sql.append("update user ");

        sql.append("set id = :id");
        if (user.getName() != null && user.getName().length() > 0) {
            sql.append(",`name` = :name");
        }
       
        sql.append(",apk = :apk ,ipa=:ipa ");

        sql.append(" where id = :id");

        return sql.toString();
    }

}

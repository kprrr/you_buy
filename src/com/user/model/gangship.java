package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * 帮会成员
 *
 * @author 张宏
 */
public class gangship extends BaseModel implements Serializable {

    private Integer id;//
    private Integer gangid;// 帮会id
    private Integer userid;// 帮会成员用户
    private String pos;// 职位
    private Integer donate;// 捐赠积分

    private String name;//
    private String password;//
    private String male;//
    private String age;//
    private String mobile;//
    private Float score;//
    private String icon;//
    private String addtime;//

    private Integer g_owner;// 帮主id
    private String g_name;// 帮派名
    private Integer g_scores;// 帮会积分
    private String g_icon;// 帮会logo

    public Integer getG_owner() {
        return g_owner;
    }

    public void setG_owner(Integer g_owner) {
        this.g_owner = g_owner;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Integer getG_scores() {
        return g_scores;
    }

    public void setG_scores(Integer g_scores) {
        this.g_scores = g_scores;
    }

    public String getG_icon() {
        return g_icon;
    }

    public void setG_icon(String g_icon) {
        this.g_icon = g_icon;
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

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGangid() {
        return gangid;
    }

    public void setGangid(Integer gangid) {
        this.gangid = gangid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getDonate() {
        return donate;
    }

    public void setDonate(Integer donate) {
        this.donate = donate;
    }

    // 生成添加语句
    public String sqlInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into gangship ");
        sql.append("(id, gangid, userid, pos, donate) ");
        sql.append("values ");
        sql.append("(:id, :gangid, :userid, :pos, :donate) ");
        return sql.toString();
    }

    // 生成删除语句
    public String sqlDelete() {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from gangship ");
        return sql.toString();
    }

    // 生成查询语句
    public String sqlSelect(gangship gangship) {
        StringBuffer sql = new StringBuffer();
        sql.append("select g.id, g.gangid, g.userid, g.pos, g.donate ");
        sql.append(",u.* ");
        sql.append(",ga.owner as g_owner ,ga.name as g_name,ga.scores as g_scores,ga.icon as g_icon ");
        sql.append("from gangship g ");
        sql.append("left join user u on g.userid = u.id ");
        sql.append("left join gang ga on g.gangid = ga.id ");

        sql.append("where 1 = 1 ");
        if (gangship.getId() != null) {
            sql.append("and  g.id = :id ");
        }
        if (gangship.getGangid() != null) {
            sql.append("and  g.gangid = :gangid ");
        }
        if (gangship.getUserid() != null) {
            sql.append("and  g.userid = :userid ");
        }
        if (gangship.getName() != null && gangship.getName().length() > 0) {
            gangship.setName("%"+ gangship.getName() +"%");
            sql.append("and  u.name like :name ");
        }
        if(gangship.getG_name()!=null && gangship.getG_name().length()>0){
            gangship.setG_name("%"+ gangship.getG_name() +"%");
            sql.append("and  ga.name like :name ");
        }

        return sql.toString();
    }

    // 生成修改语句
    public String sqlUpdate(gangship gangship) {
        StringBuffer sql = new StringBuffer();
        sql.append("update gangship ");

        sql.append("set id = :id");
        if (gangship.getGangid() != null) {
            sql.append(",gangid = :gangid");
        }
        if (gangship.getUserid() != null) {
            sql.append(",userid = :userid");
        }
        if (gangship.getPos() != null && gangship.getPos().length() > 0) {
            sql.append(",pos = :pos");
        }
        if (gangship.getDonate() != null) {
            sql.append(",donate = :donate");
        }

        return sql.toString();
    }

}

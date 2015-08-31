package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * gang_war
 *
 * @author 张宏
 */
public class gang_war extends BaseModel implements Serializable {

    private Integer id;//
    private String warid;//帮战id
    private Integer gang;//参与帮会id
    private Integer mem_num;//该帮会参与帮派人数
    private Integer score;//该帮会帮战中总共得分数
    private String war_info_id;//帮战配置id


    private String gang_name;//帮会名称

    public String getGang_name() {
        return gang_name;
    }

    public void setGang_name(String gang_name) {
        this.gang_name = gang_name;
    }

    public String getWar_info_id() {
        return war_info_id;
    }

    public void setWar_info_id(String war_info_id) {
        this.war_info_id = war_info_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarid() {
        return warid;
    }

    public void setWarid(String warid) {
        this.warid = warid;
    }

    public Integer getGang() {
        return gang;
    }

    public void setGang(Integer gang) {
        this.gang = gang;
    }

    public Integer getMem_num() {
        return mem_num;
    }

    public void setMem_num(Integer mem_num) {
        this.mem_num = mem_num;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    //生成添加语句
    public String sqlInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into gang_war ");
        sql.append("(id, warid, gang, mem_num, score) ");
        sql.append("values ");
        sql.append("(:id, :warid, :gang, :mem_num, :score) ");
        return sql.toString();
    }

    //生成删除语句
    public String sqlDelete() {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from gang_war ");
        sql.append("where id = :id ");
        return sql.toString();
    }

    //生成查询语句
    public String sqlSelect(gang_war gangWar) {
        StringBuffer sql = new StringBuffer();
        sql.append("select gw.* ");
        sql.append(",g.name as gang_name ");
        sql.append("from gang_war gw ");
        sql.append("left join gang g on g.id = gw.gang ");

        sql.append("where 1 = 1 ");
        if (gangWar.getId() != null) {
            sql.append("and gw.id = :id ");
        }
        if (gangWar.getGang() != null) {
            sql.append("and gw.gang = :gang ");
        }
        if (gangWar.getWar_info_id() != null && gangWar.getWar_info_id().length() > 0) {
            sql.append("and war_info_id = :war_info_id ");
        }
        return sql.toString();
    }

    //生成修改语句
    public String sqlUpdate(gang_war gangWar) {
        StringBuffer sql = new StringBuffer();
        sql.append("update gang_war ");

        sql.append("set id = :id");
        if (gangWar.getWarid() != null && gangWar.getWarid().length() > 0) {
            sql.append(",warid = :warid");
        }
        if (gangWar.getGang() != null) {
            sql.append(",gang = :gang");
        }
        if (gangWar.getMem_num() != null) {
            sql.append(",mem_num = :mem_num");
        }
        if (gangWar.getScore() != null) {
            sql.append(",score = :score");
        }

        sql.append(" where id = :id ");

        return sql.toString();
    }

}

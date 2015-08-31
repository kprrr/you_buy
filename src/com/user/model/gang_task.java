package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * gang_task
 *
 * @author 张宏
 */
public class gang_task extends BaseModel implements Serializable {

    private Integer id;//
    private String name;//任务名
    private String icon;//头像
    private String content;//任务说明
    private Integer score;//完成任务积分
    private String state;//
    private String url;//任务外链地址
    private String type;//
    private Integer finishtimes;//完成次数

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFinishtimes() {
        return finishtimes;
    }

    public void setFinishtimes(Integer finishtimes) {
        this.finishtimes = finishtimes;
    }

    //生成添加语句
    public String sqlInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into gang_task ");
        sql.append("(id, name, icon, content, score, state, url, type ,finishtimes) ");
        sql.append("values ");
        sql.append("(:id, :name, :icon, :content, :score, :state, :url, :type,:finishtimes) ");
        return sql.toString();
    }

    //生成删除语句
    public String sqlDelete() {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from gang_task ");
        sql.append("where id = :id ");
        return sql.toString();
    }

    //生成查询语句
    public String sqlSelect(gang_task gangTask) {
        StringBuffer sql = new StringBuffer();
        sql.append("select id, name, icon, content, score, state, url, type ,finishtimes ");
        sql.append("from gang_task where 1 = 1 ");

        if (gangTask.getId() != null) {
            sql.append("and id = :id ");
        }
        if (gangTask.getName() != null && gangTask.getName().length() > 0) {
            gangTask.setName("%" + gangTask.getName() + "%");
            sql.append("and name like :name ");
        }
        if (gangTask.getType() != null && gangTask.getType().length() > 0) {
            sql.append("and type = :type ");
        }

        return sql.toString();
    }

    //生成修改语句
    public String sqlUpdate(gang_task gangTask) {
        StringBuffer sql = new StringBuffer();
        sql.append("update gang_task ");

        sql.append("set id = :id");
        if (gangTask.getName() != null && gangTask.getName().length() > 0) {
            sql.append(",name = :name");
        }
        if (gangTask.getIcon() != null && gangTask.getIcon().length() > 0) {
            sql.append(",icon = :icon");
        }
        if (gangTask.getContent() != null && gangTask.getContent().length() > 0) {
            sql.append(",content = :content");
        }
        if (gangTask.getScore() != null) {
            sql.append(",score = :score");
        }
        if (gangTask.getState() != null && gangTask.getState().length() > 0) {
            sql.append(",state = :state");
        }
        if (gangTask.getUrl() != null && gangTask.getUrl().length() > 0) {
            sql.append(",url = :url");
        }
        if (gangTask.getType() != null && gangTask.getType().length() > 0) {
            sql.append(",type = :type");
        }
        if (gangTask.getFinishtimes() != null) {
            sql.append(",finishtimes = :finishtimes ");
        }

        sql.append(" where id = :id ");

        return sql.toString();
    }

}

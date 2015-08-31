package com.sys.model;

/**
 * 系统用户
 *
 * @author 张宏
 */
public class sys_user {

    private String id;
    private String user_name;
    private String pass_word;
    private Integer role;
    private String createtime;
    private Integer isdelete;

    // 额外字段
    private String menus;// 权限列表

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String userName) {
        user_name = userName;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String passWord) {
        pass_word = passWord;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

}

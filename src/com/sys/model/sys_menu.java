package com.sys.model;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class sys_menu {
    private String id;
    private String title;
    private String url;
    private String createuser;
    private Integer is_system;
    private String createtime;
    private String super_id;
    private String scort;
    private String icon;

    private String uid;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateuser() {
        return this.createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Integer getIs_system() {
        return this.is_system;
    }

    public void setIs_system(Integer isSystem) {
        this.is_system = isSystem;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSuper_id() {
        return this.super_id;
    }

    public void setSuper_id(String superId) {
        this.super_id = superId;
    }

    public String getScort() {
        return scort;
    }

    public void setScort(String scort) {
        this.scort = scort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String json(List<sys_menu> list) {
        JSONArray array = new JSONArray();
        for (sys_menu menu : list) {
            JSONObject jo = new JSONObject();
            jo.put("id", menu.getId());
            jo.put("text", menu.getTitle());
            if (!menu.getSuper_id().equals("0")) {
                jo.put("pid", menu.getSuper_id());
            }
            if (menu.getIcon() != null) {
                jo.put("iconCls", menu.getIcon());
            }
            JSONObject att = new JSONObject();
            att.put("url", menu.getUrl());
            jo.put("attributes", att);
            array.add(jo);
        }
        return array.toString();
    }
}
package com.sys.dao.imp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.sys.dao.SysUserDao;
import com.sys.model.admin;
import com.sys.model.sys_menu;
import com.sys.model.sys_user;


@Component("sysUserDao")
@Scope("prototype")
public class SysUserDaoImp extends JdbcDao implements SysUserDao {

    public PageList getSysUser(sys_user sysUser, String pageSize, String pageNo) {
        // TODO Auto-generated method stub
        StringBuffer sql = new StringBuffer();
        sql.append("select * from sys_user where 1=1 ");
        if (sysUser.getUser_name() != null && sysUser.getUser_name().length() > 0) {
            sysUser.setUser_name("%" + sysUser.getUser_name() + "%");
            sql.append("and user_name like :user_name ");
        }
        if (sysUser.getRole() != null) {
            sql.append("and role = :role ");
        }
        if (sysUser.getId() != null) {
            sql.append("and id = :id ");
        }
        if (sysUser.getIsdelete() != null) {
            sql.append("and isdelete = :isdelete ");
        }
        sql.append(" order by isdelete desc, createtime ");
        PageList pl = new PageList();
        List<sys_user> list;
        int counts = this.getCount(sql.toString(), sysUser);
        if (pageSize != null) {
            list = this.selectSql(sql.toString(), sysUser, pageSize, pageNo);
            int pageCount = this.getPageCount(counts, pageSize);
            pl.setPageCount(pageCount);
        } else {
            list = this.selectSql(sql.toString(), sysUser);
        }
        pl.setList(list);
        pl.setCounts(counts);
        return pl;
    }

    public String addUser(sys_user sysUser) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        String isSql = "select * from sys_user where user_name = :user_name";
        List<sys_user> list = this.selectSql(isSql, sysUser);
        if (list.size() > 0) {
            mess = this.codeMess(eCode, "此用户已存在!");
        } else {
            String userId = sysUser.getId();
            if(userId==null){
                userId = createKey();
            }
            sysUser.setId(userId);
            StringBuffer sql = new StringBuffer();
            sql.append("insert into sys_user ");
            sql.append("(id,user_name,pass_word,role,isdelete) ");
            sql.append("values ");
            sql.append("(:id,:user_name,:pass_word,:role,:isdelete)");
            if (!this.executeSql(sysUser, sql.toString())) {
                mess = this.codeMess(eCode, "保存用户失败!");
            } else {
                //判断是否为管理员
                if (sysUser.getRole() == 0) {//需要计算有哪些权限
                    if (sysUser.getMenus().length() > 0) {
                        String[] menuSql = this.getMenusSql(sysUser.getMenus(), userId);
                        this.executeSql(menuSql);
                    }
                }
            }
        }
        return mess;
    }

    public String deleteUser(sys_user sysUser) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        String sql = "delete from sys_user where id = '" + sysUser.getId() + "'";
        String msql = "delete from sys_usermenu where uid = '" + sysUser.getId() + "'";
        if (!this.executeSql(sql, msql)) {
            mess = this.codeMess(eCode, "操作失败！");
        }
        return mess;
    }

    public String updateUser(sys_user sysUser) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        String msql = "delete from sys_usermenu where uid = '" + sysUser.getId() + "'";
        String sql = "update sys_user set pass_word = :pass_word,role = :role ,isdelete = :isdelete ";
        sql += "where id = :id ";
        if (!this.executeSql(sysUser, sql)) {
            mess = this.codeMess(eCode, "修改失败!");
        } else {
            this.executeSql(msql);
            //判断是否为管理员
            if (sysUser.getRole() == 0) {//需要计算有哪些权限
                String[] menuSql = this.getMenusSql(sysUser.getMenus(), sysUser.getId());
                this.executeSql(menuSql);
            }
        }
        return mess;
    }

    public String updatePass(sys_user sysUser) {
        String mess = this.codeMess(sCode, sMess);
        String sql = "update sys_user set pass_word = :pass_word where id = :id ";
        if (!this.executeSql(sysUser, sql)) {
            mess = this.codeMess(eCode, "修改失败!");
        }
        return mess;
    }

    //读取菜单列表
    private String[] getMenusSql(String ids, String userId) {
        ids = "('" + ids.replaceAll(",", "','") + "')";
        String sql = "select * from sys_menu where id in " + ids;
        List<sys_menu> menus = this.selectSql(sql, new sys_menu());
        List<String> idList = new ArrayList<String>();
        List<String> sqls = new ArrayList<String>();
        for (sys_menu menu : menus) {
            if (!idList.contains(menu.getId())) {
                idList.add(menu.getId());
                sqls.add(String.format("insert into sys_usermenu values('%s','%s','%s',now(),1)", createKey(), userId, menu.getId()));
            }

        }
        String[] tempSqls = new String[sqls.size()];
        for (int i = 0; i < sqls.size(); i++) {
            tempSqls[i] = sqls.get(i);
        }
        return tempSqls;
    }

    public admin getUser(admin sysUser) {
        // TODO Auto-generated method stub
        String sql = "select * from admin where name = :name and isdelete = 1";
        List<admin> menus = this.selectSql(sql, sysUser);
        if (menus.size() > 0) {
            return menus.get(0);
        }
        return null;
    }


}

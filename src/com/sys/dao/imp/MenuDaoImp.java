package com.sys.dao.imp;

import com.base.JdbcDao;
import com.sys.dao.MenuDao;
import com.sys.model.sys_menu;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sysMenuDao")
@Scope("prototype")
public class MenuDaoImp extends JdbcDao implements MenuDao {
    public List<sys_menu> getMenus(sys_menu menu) {
        String sql = "select * from sys_menu where 1=1 ";
        if (menu.getUid() != null) {
            sql += "and id in (select mid from sys_usermenu where uid = :uid) ";
        }else{
            sql +="and id !='45b8f4e1880cbdfcadce8ec66399cb3e' and super_id!='45b8f4e1880cbdfcadce8ec66399cb3e' ";
        }
        if (menu.getId() != null) {
            sql += "and id = :id ";
        }
        if (menu.getSuper_id() != null) {
            sql += "and super_id = :super_id ";
        }
        sql += " order by super_id desc, createtime";
        return selectSql(sql, menu);
    }

    public String addMenu(sys_menu menu) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        String id = createKey();
        menu.setId(id);
        //查询上级的scort
        if (!menu.getSuper_id().equals("0")) {
            sys_menu sysMenu = new sys_menu();
            sysMenu.setId(menu.getSuper_id());
            String sql = "select * from sys_menu where id = :id";
            sysMenu = (sys_menu) this.selectSql(sql, sysMenu).get(0);
            menu.setScort(sysMenu.getScort());
        }
        menu.setScort((menu.getScort() == null ? "" : menu.getScort()) + id + ",");
        StringBuffer sql = new StringBuffer();
        sql.append("insert into sys_menu (id,title,url,createuser,is_system,super_id,scort)");
        sql.append("values ");
        sql.append("(:id,:title,:url,:createuser,:is_system,:super_id,:scort)");
        if (!this.executeSql(menu, sql.toString())) {
            mess = this.codeMess(eCode, "添加失败!");
        }
        return mess;
    }

    public String deleteMenu(sys_menu menu) {
        // TODO Auto-generated method stub

        String mess = this.codeMess(sCode, sMess);

        String sql = "select * from sys_menu where id = :id";
        List<sys_menu> menus = this.selectSql(sql, menu);

        sql = "delete from sys_menu where id = '" + menu.getId() + "'";
        this.executeSql(sql);

        //开始删除下级菜单
        while (menus.size() > 0) {
            String ids = "";
            for (sys_menu m : menus) {
                ids += "'" + m.getId() + "',";
            }
            if (!ids.equals("")) {
                ids = ids.substring(0, ids.length() - 1);
                sql = "delete from sys_menu where super_id in(" + ids + ");";
                this.executeSql(sql);
                sql = "select * from sys_menu where super_id in(" + ids + ")";
                menus = this.selectSql(sql, menu);
            }
        }
        return mess;
    }

    public String updateMenu(sys_menu menu) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);

        StringBuffer sql = new StringBuffer();
        sql.append("update sys_menu set id = :id");
        if (menu.getTitle() != null) {
            sql.append(",title = :title");
        }
        if (menu.getUrl() != null) {
            sql.append(",url = :url");
        }
        sql.append(" where id = :id ");
        if (!this.executeSql(menu, sql.toString())) {
            mess = this.codeMess(eCode, "修改失败!");
        }
        return mess;
    }
}
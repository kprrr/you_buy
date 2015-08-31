package com.sys.action;

import com.base.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.dao.MenuDao;
import com.sys.model.sys_menu;
import com.sys.model.sys_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("sysMenuAction")
@Scope("prototype")
public class MenuAction extends BaseAction implements ModelDriven<sys_menu> {

    @Autowired
    @Resource
    public MenuDao sysMenuDao;
    sys_menu menu = new sys_menu();

    //sysMenu-get
    public void get() {
        sys_user loginUser = this.loginSystemUser();
        if (loginUser != null) {
            if (loginUser.getRole() != 1) {
                menu.setUid(loginUser.getId());
            }
            List list = this.sysMenuDao.getMenus(this.menu);
            outJson(this.menu.json(list));
        }
    }

    //sysMenu-add
    public void add() {
        sys_user loginUser = this.loginSystemUser();
        if (loginUser != null) {
            String mess = sysMenuDao.addMenu(menu);
            this.outJson(mess);
        }
    }

    //sysMenu-remove
    public void remove() {
        sys_user loginUser = this.loginSystemUser();
        if (loginUser != null) {
            String mess = sysMenuDao.deleteMenu(menu);
            this.outJson(mess);
        }
    }

    //sysMenu-update
    public void update() {
        sys_user loginUser = this.loginSystemUser();
        if (loginUser != null) {
            String mess = sysMenuDao.updateMenu(menu);
            this.outJson(mess);
        }
    }

    public sys_menu getModel() {
        return this.menu;
    }
}

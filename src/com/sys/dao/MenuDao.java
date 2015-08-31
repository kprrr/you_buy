package com.sys.dao;

import com.sys.model.sys_menu;

import java.util.List;

public abstract interface MenuDao {

    List<sys_menu> getMenus(sys_menu paramsys_menu);

    String addMenu(sys_menu menu);

    String deleteMenu(sys_menu menu);

    String updateMenu(sys_menu menu);
}
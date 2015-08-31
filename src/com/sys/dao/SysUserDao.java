package com.sys.dao;

import com.base.PageList;
import com.sys.model.admin;
import com.sys.model.sys_user;

public interface SysUserDao {


	admin getUser(admin sys_user);

    /**
     * 获取用户列表
     *
     * @param sysUser
     * @param pageSize
     * @param pageNo
     * @return
     */
    PageList getSysUser(sys_user sysUser, String pageSize, String pageNo);

    /**
     * 保存用户信息
     *
     * @param sysUser
     * @return
     */
    String addUser(sys_user sysUser);

    /**
     * 删除用户信息
     *
     * @param sysUser
     * @return
     */
    String deleteUser(sys_user sysUser);

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    String updateUser(sys_user sysUser);

    public String updatePass(sys_user sysUser);
}

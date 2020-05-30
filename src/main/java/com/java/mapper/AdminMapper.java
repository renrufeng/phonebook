package com.java.mapper;

import com.java.entity.Admin;

/**
 * 管理员mapper接口
 *
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-16 12:57
 */

public interface AdminMapper {

    /**
     * 管理员登录
     *
     * @param admin
     * @return
     */
    public Admin login(Admin admin);
}

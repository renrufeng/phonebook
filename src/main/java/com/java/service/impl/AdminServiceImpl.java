package com.java.service.impl;

import com.java.entity.Admin;
import com.java.mapper.AdminMapper;
import com.java.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-16 13:20
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.login(admin);

    }
}
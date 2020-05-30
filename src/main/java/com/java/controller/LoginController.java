package com.java.controller;

import com.java.constant.SystemConstant;
import com.java.entity.Admin;
import com.java.entity.R;
import com.java.service.AdminService;
import com.java.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-16 13:43
 */

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public R login(@RequestBody Admin admin) throws Exception {
        Admin u = adminService.login(admin);

        R r = new R();
        if (u == null) {
            return R.error("用户名或密码错误");
        } else {
            String token = JwtUtils.createJWT(String.valueOf(u.getId()), u.getUserName(), SystemConstant.JWT_TTL);
            r.put("token", token);
        }

        return r;

    }

}

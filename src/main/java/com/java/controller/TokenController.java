package com.java.controller;

import com.java.constant.SystemConstant;
import com.java.entity.R;
import com.java.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 刷新token
 *
 * @author java1234_小锋
 * @site www.java1234.com
 * @company Java知识分享网
 * @create 2019-09-14 下午 9:58
 */
@RestController
@RequestMapping("/")
public class TokenController {

    private final Logger logger = LoggerFactory.getLogger(TokenController.class);

    /**
     * 刷新用户token
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/refreshToken")
    public R refreshToken(HttpServletRequest request) {
        Claims claims = JwtUtils.validateJWT(request.getHeader("token")).getClaims();
        String newToken = JwtUtils.createJWT(claims.getId(), claims.getSubject(), SystemConstant.JWT_TTL);
        R r = new R();
        r.put("token", newToken);
        logger.info("新token:" + newToken);
        return r;
    }

}

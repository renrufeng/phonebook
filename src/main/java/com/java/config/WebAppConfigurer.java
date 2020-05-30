package com.java.config;

import com.java.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author java1234_小锋
 * @site www.java1234.com
 * @company Java知识分享网
 * @create 2019-09-11 下午 1:22
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    /**
     * 配置不需要拦截的请求
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = new String[]{"/login", "/*.html", "/image"};
        registry.addInterceptor(new SysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:\\userImages\\");

    }

}

package com.liyuan.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:LiYuan
 * @description:用户Authorthon验证拦截器
 * @Date:Create in 11:02 2018/5/12
 * @Modified By:
 */
@Component
public class JwtInterceptor implements HandlerInterceptor{

    private List<String> excludes;
    private String redirectUrl;
    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String urlPath = httpServletRequest.getRequestURI();
        System.out.println("uri:"+urlPath);
        if (!urlPath.startsWith("/")) {
            urlPath = "/" + urlPath;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

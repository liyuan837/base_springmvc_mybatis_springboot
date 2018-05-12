package com.liyuan.demo.config;

import com.liyuan.demo.JwtInterceptor;
import com.liyuan.demo.filter.AccessFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Autowired
    private AccessFilter accessFilter;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{
                "/favicon**", "/error", "/*.html", "/swagger*", "/v2/*", "*/productDetail"
        };
        jwtInterceptor.setExcludes(Arrays.asList(excludes));
        jwtInterceptor.setRedirectUrl("/");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**");
    }


    /**
     * 过滤处理跨域请求
     */
    @Bean
    public FilterRegistrationBean filterCORSRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setUrlPatterns(Arrays.asList(new String[]{"/*"}));
        registrationBean.setFilter(accessFilter);
        registrationBean.setOrder(3);
        return registrationBean;
    }


}

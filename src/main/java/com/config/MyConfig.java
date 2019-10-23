package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.Interceptors.*;



@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //加拦截器
        /*
         /index 只拦截index
         /*拦截所有

         */

        registry.addInterceptor(new LoginInterceptors()).addPathPatterns("/*");
        registry.addInterceptor(new TokenInterceptors()).addPathPatterns("/*");
    }
}

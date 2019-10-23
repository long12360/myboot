package com.Interceptors;

import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.service.*;
import com.entity.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.support.WebApplicationContextUtils;


//基本拦截器
public class BaseInterceptors{

    protected Object getBean(ServletContext ctx,String beanName){
     ApplicationContext  ac = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
     Object obj = ac.getType(beanName);

     return obj;
    }


}

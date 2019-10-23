package com.Interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod){
            HandlerMethod hand = (HandlerMethod)handler;
            Method  md = hand.getMethod();
            Token token = md.getAnnotation(Token.class);
            if(token !=null){
                boolean chtoken = token.check();
                if (chtoken){//可以判断重复提交
                  boolean ck2 =   checktoken(request);
                  if(ck2==false){
                      response.sendRedirect("/myboot/repent.jsp");
                      return false;
                  }else {
                      //清空token

                      request.getSession().removeAttribute("token");
                  }

                }
            }
        }

        return true;
    }
    //false  要拦截，true是不拦截
    private   boolean checktoken(HttpServletRequest request){
        boolean ck = false;
        String rnum = request.getParameter("token");
        Object snum = request.getSession().getAttribute("token");
        if(rnum!=null && snum!=null && rnum.equals(snum)){
            ck = true;

        }

        return  ck;
    }
}

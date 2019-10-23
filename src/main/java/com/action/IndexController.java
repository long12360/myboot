package com.action;
import java.util.*;

import com.Interceptors.Login;
import com.Interceptors.Token;
import com.entity.*;
import com.service.*;
import com.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private RedisClient client;
    @Autowired
    private  IDemoService dd;

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView mvo){
        System.out.println("来了老弟");
        List<Demo> list = dd.selectAll();
        for (Demo d:list) {
            System.out.println("-----是什么="+d);
        }

        mvo.setViewName("success");
        return  mvo;
    }
    @Token(check = true)
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mvo, UserBean u, HttpSession session){
        System.out.println("第一次有对象进来吗？"+u);
        if ("管理员".equals(u.getUser()) && "admin123".equals(u.getPwd())){
            System.out.println("有对象进来吗？"+u);
            Object uobj = client.get("userinfo");
            if(uobj==null){
                //加入redis
                client.set("userinfo",u);
                client.expire("userinfo",1800);
            }


            mvo.setViewName("success");


        }else {
            System.out.println("l来了吗 老弟");
            mvo.addObject("loginerror","用户名或密码错误");
            mvo.setViewName("login");
        }
        return mvo;
    }

    @Login(check = true)
    @RequestMapping("/main")
    public ModelAndView main(ModelAndView mvo){
         System.out.println("-------------mian");

          mvo.setViewName("main");
        return  mvo;
    }
}

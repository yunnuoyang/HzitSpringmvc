package com.joinx.interceptor.controller;

import com.joinx.interceptor.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class InitController {
    @RequestMapping("init")
    public String init(){
        System.out.println("===========1111=======");
        return "login";
    }
    @RequestMapping("login")
    public String login(User user, ModelMap map){
        System.out.println("0000"+user);
        map.put("user",user);
        return "redirect:index.jsp";
    }
    @RequestMapping("logout")
    public String logout(SessionStatus status){
        status.setComplete();
        System.out.println("===========1111=======");
        return "index";
    }
    @RequestMapping("show")
    public String show(){

        return "show";
    }
}

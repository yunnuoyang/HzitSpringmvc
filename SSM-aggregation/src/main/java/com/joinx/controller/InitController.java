package com.joinx.controller;

import com.joinx.pojo.Account;
import com.joinx.pojo.User;
import com.joinx.service.ICountService;
import com.joinx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class InitController {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;
    @Autowired
    @Qualifier("countService")
    private ICountService countService;
    @RequestMapping("/init")
    public String init(){HttpServletResponse response=null;
        String s = response.encodeURL("/init");
        
        System.out.println("===========");
        User userByID = userService.getUserByID(1);
        System.out.println(userByID);
        return "";
    }
    @RequestMapping("trance")
    public String trance(Account account){
        Account a=new Account();
        a.setAccName("张三");
        countService.tranceferTo(a,account,account.getBalance());
        return null;

    }}

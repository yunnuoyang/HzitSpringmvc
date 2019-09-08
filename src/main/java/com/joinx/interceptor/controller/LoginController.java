package com.joinx.interceptor.controller;

import com.joinx.interceptor.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("hello")
    public String hello(){
        int a=2/0;
        String str="";
        str=str.substring(0,100);
        System.out.println("here................");
        return "hello";
    }
    @RequestMapping("/login")
    public String add(User user, ModelMap modelMap){
        String[] sex={"男","女"};
        String[] hobby={"踢足球","看电视","打游戏"};
        modelMap.put("sex",sex);
        modelMap.put("hobby",hobby);
        System.out.println("============add=====");
        return "login";
    }
    @RequestMapping("addUser")
    public  String addUser(@Validated User user, BindingResult bindingResult){
        String str="";
        str=str.substring(0,100);
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String message = fieldError.getDefaultMessage();
            System.out.println(message);
            return "login";
        }
        System.out.println(user);
        return "";
    }
    @RequestMapping("loginInter")
    public String loginInter(User user){

        return "login2";
    }

//    @ExceptionHandler(Exception.class)
    //第一种配置全局异常
//    public String myexec(Exception exception, HttpServletRequest request){
//        System.out.println("========异常了！======"+exception.getMessage());
//        request.setAttribute("exception",exception);
//        return "error";
//    }
}

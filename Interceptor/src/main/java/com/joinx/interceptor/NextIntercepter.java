package com.joinx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextIntercepter implements HandlerInterceptor {
    private String username="张三";
    private String password="123";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uname = request.getParameter("username");
        String pwd=request.getParameter("password");
            if (username.equals(uname)&&password.equals(pwd))
            {
                System.out.println("登陆成功");
                return true;
            }
            else{
                System.out.println("用户名密码不正确");
                return false;
            }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

package com.joinx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class Interceptor implements HandlerInterceptor {


    private String[] ips={"192.168.43.254",""};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        boolean is = Arrays.asList(ips).contains(ip);
        if (is){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('傻逼，滚')</script>");
        return false;
        }
        System.out.println("===222=======");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-----333---------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("==========444=============");
    }
}

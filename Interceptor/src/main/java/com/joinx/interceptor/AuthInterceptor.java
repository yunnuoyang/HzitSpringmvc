package com.joinx.interceptor;

import com.joinx.interceptor.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("========User========"+user);
        if (user==null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script>alert('请登录');location='index.jsp';</script>");
            return false;
        }
        return true;
    }
};

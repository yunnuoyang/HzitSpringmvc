package com.joinx.interceptor.controller;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
//@Component("initController")
//@SessionAttributes(value ="",names = {""})//将request域中的值放进session中
//@PropertySource("classpath:resources.properties")
public class InitController extends AbstractController {
//    @Value("${viewName}")
    private String viewName;

    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        String parameter = request.getParameter("ss");
        System.out.println(parameter+"===============");
        ModelAndView mv=new ModelAndView();
        System.out.println("===="+viewName);
        mv.addObject("name","张飞");
        mv.setViewName(viewName);
        return mv;
    }
}

package com.joinx.interceptor.controller;

import com.joinx.converter.DateCovertor;
import com.joinx.interceptor.pojo.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("file")
public class ConverterController {
    @RequestMapping("convert")
    public String convert(File file,ModelMap map){
        return "convert";
    }
    @RequestMapping("doconvert")
    public String doconvert(File file,ModelMap map){
        System.out.println(file.getUpDate()+"===========");
        map.put("file",file);
        return "convertshow";
    }
    @InitBinder
    public void inBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new DateCovertor());
    }
}

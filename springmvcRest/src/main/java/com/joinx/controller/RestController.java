package com.joinx.controller;

import com.joinx.pojo.Human;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/getresources")
    public Human getresources(){
        Human human=new Human();
        human.setId(2);
        human.setName("张三");
        human.setSex('男');
        return human;
    }
    @PostMapping(value = "/addresources",produces = "application/json;charset=UTF-8",headers="Accept",consumes="application/json;charset=UTF-8")
    public Human addresources( @RequestBody Human human, HttpServletRequest request){
        Enumeration<String> accept = request.getHeaders("Accept");
        while (accept.hasMoreElements()){
            System.out.println(accept.nextElement());
        }
        System.out.println(human+"====");
        return human;
    }
    @PutMapping("/updateresources")
    public Human updateresources(@RequestBody Human hum){
        Human human=new Human();
        human.setId(3);
        human.setSex('女');
        human.setName("李四");
        System.out.println(human+"修改前");
        human.setName(hum.getName());
        human.setId(hum.getId());
        System.out.println(human+"修改后");
        return human;

    }
        @DeleteMapping("deleteresources/{id}")
    public Human deleteResources(@PathVariable String id){
            System.out.println("删除id="+id+"的数据");
         return new Human();
        }
}

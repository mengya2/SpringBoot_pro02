package com.zww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/user/account")
    @ResponseBody
    public String account(){
        return "访问的页面是account的";
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public String login(){
        return "访问的是进行排除处理的/user/login";
    }
}

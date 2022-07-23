package com.zww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilterController {
    /**
     * 访问这个的时候没有显示出来东西，也就是给过滤掉了
     * @return
     */
    @RequestMapping("/user/account")
    @ResponseBody
    public String hello(){
        return "/user/account";
    }
    @RequestMapping("/query")
    @ResponseBody
    public String doSome() {
        return "/query";
    }
}

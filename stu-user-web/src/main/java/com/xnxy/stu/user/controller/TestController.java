package com.xnxy.stu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("test")
    public String Test(){
        return "DateTest";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}

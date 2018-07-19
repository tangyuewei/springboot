package com.tyw.controller;

import com.tyw.domian.User;
import com.tyw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
* @Description :
* @Date : 2018/7/19  18:28  
* */
@Controller
public class ThymeleafController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "https://github.com/Yannik007/springboot");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public String userList(ModelMap map) {
        List<User> userList = userService.findAll();
        map.addAttribute("userList",userList);
        return "/user/userList";
    }
}

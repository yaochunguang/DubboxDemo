package com.company.dubbox.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.dubbox.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: chunguang.yao
 * @date: 2019-06-28 0:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/showName")
    @ResponseBody
    public String showName() {
        return userService.getName();
    }
}

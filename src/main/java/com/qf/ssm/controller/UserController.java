package com.qf.ssm.controller;

import com.qf.ssm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping
    public Object getPageData(int pageNum ,int pageSize) {
        return userService.getPageData(pageNum,pageSize);
    }
}

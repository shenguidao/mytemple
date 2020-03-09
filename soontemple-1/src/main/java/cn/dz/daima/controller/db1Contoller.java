package cn.dz.daima.controller;

import cn.dz.daima.mapper.db1.UserMapper1;
import cn.dz.daima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db1")
public class db1Contoller {
    @Autowired
    private UserMapper1 userMapper1;

    @GetMapping("/select")
    public void selectUserList() {
        System.out.println(userMapper1.search());
    }



}

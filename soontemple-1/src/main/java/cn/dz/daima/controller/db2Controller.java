package cn.dz.daima.controller;

import cn.dz.daima.mapper.db2.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db2")
public class db2Controller {
    @Autowired
    private UserMapper2 userMapper2;

    @GetMapping("/select")
    public void selectUserList() {
        System.out.println(userMapper2.search());
    }

}

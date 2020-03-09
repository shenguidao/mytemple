package cn.dz.daima.controller;

import cn.dz.daima.service.UserService;
import com.m2g.offtake.entity.RestMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

@RestController
@RequestMapping(value = "/userApi")
@Api(value = "用户相关接口", tags = {"用户相关接口"})
public class UserApi extends BaseApi {
    private static final Logger log = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private UserService userService;

    @GetMapping("/UserTest")
    @ApiOperation(value = "测试")
    public RestMap get(@ApiParam(name = "userId", value = "用户id") @RequestParam(value = "userId") Integer userId) {
        return userService.query(userId);
    }

}

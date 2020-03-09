package cn.dz.daima.service;

import cn.dz.daima.mapper.UserMapper;
import com.m2g.offtake.entity.RestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public RestMap query(Integer userId) {
        return new RestMap("succe","succe",null);
    }
}

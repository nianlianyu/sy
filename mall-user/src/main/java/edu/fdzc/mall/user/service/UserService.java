package edu.fdzc.mall.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.fdzc.mall.user.entity.User;
import edu.fdzc.mall.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(); // 用于构造查询条件
        queryWrapper.eq("username", username)
                .eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }
}
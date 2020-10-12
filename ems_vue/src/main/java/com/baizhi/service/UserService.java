package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/8
 * Time: 14:16
 * Description: No Description
 */
public interface UserService {
    //用户注册
    void register(User user);
    //用户登录
    User login (User user);
}

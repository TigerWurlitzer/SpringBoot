package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.w3c.dom.UserDataHandler;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/8
 * Time: 14:17
 * Description: No Description
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        //根据用户输入的用户名判断用户是否存在
        User userDB = userDAO.findByUserName(user.getUsername());
        if (userDB == null) {
            //生成用户状态
            user.setStatus("已激活");
            //设置用户注册时间
            user.setRegisterTime(new Date());
            //调用DAO
            //ID在插入时由数据库自动生成，用户名、密码、真实姓名和性别等信息由页面（前端）传过来
            //不需要由后端来操控，所以后面可以直接调用DAO层的接口。
            userDAO.save(user);
        } else {
            throw new RuntimeException("用户名已存在");
        }
    }
    @Override
    public User login(User user){
        //根据用户输入用户名进行查询
        User userDB = userDAO.findByUserName(user.getUsername());
        if(!ObjectUtils.isEmpty(userDB)){//使用工具类判断userDB这个对象是否为空
            //比较密码是否正确
            if (userDB.getPassword().equals(user.getPassword())) {
                return userDB;
            }else{
                throw new RuntimeException("密码错误");
            }
        }else{
            throw new RuntimeException("用户名不能为空");//抛异常相当于返回
        }
    }


}

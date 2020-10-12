package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/8
 * Time: 14:25
 * Description: 用户Controller
 */
@RestController
@CrossOrigin//允许跨域
@RequestMapping(value = "user", produces = "application/json;charset=UTF-8")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用于测试
     *
     * @param
     * @return
     */
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }

    /**
     * 处理用户注册的方法
     *
     * @param
     * @return
     */
    @PostMapping("register")
    public Map<String, Object> register(@RequestBody User user, HttpServletRequest request) {
        log.info("用户信息:[{}]", user.toString());
        Map<String, Object> map = new HashMap<>();
        try {
            //调用业务方法
            userService.register(user);
            map.put("state", true);
            map.put("msg", "注册成功");
        } catch (Exception e) {
//            捕获异常
            e.printStackTrace();
            map.put("state", false);
//            直接将异常信息捕获到
            map.put("msg", "提示:" + e.getMessage());
        }
        return map;
    }

    /**
        *
        *用户登录
        *@param
        *@return
        *
    */
    @PostMapping("login")
    public Map<String, Object>login(@RequestBody User user,HttpServletRequest request){
        //@RequestBody用于接收转换成json对象
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);//如果登录成功会将数据库中的对象进行返回
            map.put("state", true);
            map.put("msg", "登陆成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;

    }
}

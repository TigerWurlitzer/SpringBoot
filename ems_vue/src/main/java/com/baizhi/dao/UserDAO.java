package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/8
 * Time: 13:36
 * Description: No Description
 */
@Mapper//创建DAO对象
public interface UserDAO {
    void save(User user);
    User findByUserName(String username);
}

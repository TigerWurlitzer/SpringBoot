package com.baizhi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/8
 * Time: 13:31
 * Description: 构建用户对象的实体类
 */
@Data
@Accessors(chain = true)
//mapper文件中取值的时候对应的是该实体中的各个属性值
public class User {
    private String id;//String类型的API多
    private String username;
    private String realname;
    private String password;
    private String sex;
    private String status;
    private Date registerTime;
}

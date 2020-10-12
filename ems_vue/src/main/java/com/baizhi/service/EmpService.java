package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/9
 * Time: 10:28
 * Description: 员工业务层接口
 */
public interface EmpService {

    //员工添加
    void add(Emp emp);

    //查询所有
    List<Emp> findAll();

    //删除员工信息
    void delete(String id);

    //查询单个员工信息
    Emp findOne(String id);

    //修改员工信息
    void update(Emp emp);
}

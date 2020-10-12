package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/9
 * Time: 10:17
 * Description: 员工DAO
 */
@Mapper
public interface EmpDAO {
    void add(Emp emp);
    void update(Emp emp);
    List<Emp> findAll();
    Emp findOne(String id);
    Emp findByEmpName(String empname);
    void delete(String id);
}

package com.baizhi.service;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/9
 * Time: 10:29
 * Description: 员工信息业务层实现类
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpDAO empDAO;

    @Override
    public void add(Emp emp) {
        //根据name判断员工是否存在
        Emp empDB = empDAO.findByEmpName(emp.getEmpname());
        if (empDB == null) {
            //生成用户状态
            empDAO.add(emp);
        } else {
            throw new RuntimeException("员工已存在");
        }
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDAO.findAll();
    }
    @Override
    public void delete(String id) {
        empDAO.delete(id);
    }

    @Override
    public Emp findOne(String id) {
        return empDAO.findOne(id);
    }

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }
}

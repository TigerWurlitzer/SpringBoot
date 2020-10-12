package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/9
 * Time: 10:39
 * Description: 员工信息Controller
 */
@RestController
@CrossOrigin//允许跨域
@RequestMapping(value = "emp", produces = "application/json;charset=UTF-8")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     *
     *处理员工添加功能
     * @param
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> add(@RequestBody Emp emp, HttpServletRequest request) {
        log.info("员工信息:[{}]", emp.toString());//用于打印信息
        Map<String, Object> map = new HashMap<>();
        try {
            //调用业务方法
            empService.add(emp);
            map.put("state", true);
            map.put("msg", "添加成功");
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
     *查询所有员工列表
     * @param
     * @return
     */
    @GetMapping("findAll")
    public List<Emp> findAll() {
        return empService.findAll();
    }

    /**
     *
     *删除员工信息
     * @param
     * @return
     */
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除员工:[{}]", id);
        Map<String, Object> map = new HashMap<>();//返回信息如果需要以map的形式体现则需要用到Map
        try {
            empService.delete(id);
            map.put("state", true);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "删除失败");
        }
        return map;
    }
    /**
        *
        *根据ID查询一个员工信息
        *@param
        *@return
        *
    */
    @GetMapping("findOne")
    public Emp findOne(String id){
        log.info("查询员工信息的id:[{}]",id);
        return empService.findOne(id);
    }
    /**
     *
     *修改员工信息
     * @param
     * @return
     */
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Emp emp, HttpServletRequest request) {
        log.info("员工信息:[{}]", emp.toString());//用于打印信息
        Map<String, Object> map = new HashMap<>();
        try {
            //调用业务方法
            empService.update(emp);
            map.put("state", true);
            map.put("msg", "修改成功");
        } catch (Exception e) {
//            捕获异常
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "修改失败");
        }
        return map;
    }
}

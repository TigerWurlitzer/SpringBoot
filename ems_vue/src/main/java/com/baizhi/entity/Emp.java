package com.baizhi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/10/9
 * Time: 10:15
 * Description: No Description
 */
@Data
@Accessors(chain = true)
public class Emp {
    private String id;
    private String empname;
    private String path;
    private Double salary;
    private Integer age;
}

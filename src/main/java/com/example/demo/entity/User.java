package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangyu
 * @date 2018/12/14 11:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User  extends BaseEntity{
    private String name;
    private String email;
    private int age;
}

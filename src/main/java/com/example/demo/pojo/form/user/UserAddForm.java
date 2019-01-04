package com.example.demo.pojo.form.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangyu
 * @date 2018/12/14 11:45
 */
@Data
public class UserAddForm {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("年龄")
    private int age;
}

package com.example.demo.pojo.form.user;

import com.example.demo.pojo.form.base.BasePageForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangyu
 * @date 2018/12/14 17:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQueryForm extends BasePageForm {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("年龄")
    private Integer age;
}

package com.example.demo.pojo.form.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangyu
 * @date 2018/12/14 14:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateForm extends UserAddForm {
    private long id;
}

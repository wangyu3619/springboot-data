package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;
import com.example.demo.pojo.form.user.UserQueryForm;
import com.example.demo.pojo.utils.PageResult;


/**
 * @author wangyu
 * @date 2018/12/14 11:39
 */
public interface UserService  extends IService<User> {

    /**
     * 分页查询User
     * @param userQueryForm QueryFor
     * @param page 页码
     * @param pageSize 分页大小
     * @return
     */
    PageResult selectList(UserQueryForm userQueryForm, int page, int pageSize);
}

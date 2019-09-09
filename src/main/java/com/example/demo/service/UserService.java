package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.pojo.form.user.UserQueryForm;
import com.example.demo.pojo.utils.PageResult;


/**
 * @author wangyu
 * @date 2018/12/14 11:39
 */
public interface UserService {

    /**
     * 分页查询User
     *
     * @param userQueryForm QueryFor
     * @param page          页码
     * @param pageSize      分页大小
     * @return
     */
    PageResult selectList(UserQueryForm userQueryForm, int page, int pageSize);

    /**
     * 保存用户信息
     *
     * @param userInfo info
     * @return boolean
     */
    boolean save(User userInfo);

    /**
     * 删除记录
     *
     * @param id id
     * @return boolean
     */
    boolean removeById(long id);

    /**
     * 更细信息
     *
     * @param user 实体
     * @return boolean
     */
    boolean updateById(User user);

}

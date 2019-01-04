package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.form.user.UserQueryForm;
import com.example.demo.pojo.utils.PageResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.EntityUtils;
import org.springframework.stereotype.Service;


/**
 * @author wangyu
 * @date 2018/12/14 11:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public PageResult selectList(UserQueryForm userQueryForm, int page, int pageSize) {
        QueryWrapper<User> queryWrapper = EntityUtils.getQueryWrapper(userQueryForm);
        IPage<User> pageList =  baseMapper.selectPage(new Page<>(page, pageSize),queryWrapper);
        return PageResult.build(pageList.getRecords(),pageList.getTotal());
    }
}

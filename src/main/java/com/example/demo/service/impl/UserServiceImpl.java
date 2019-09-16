package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.form.user.UserQueryForm;
import com.example.demo.pojo.utils.PageResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author wangyu
 * @date 2018/12/14 11:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult selectList(UserQueryForm userQueryForm, int page, int pageSize) {
        QueryWrapper<User> queryWrapper = EntityUtils.getQueryWrapper(userQueryForm);
        IPage<User> pageList = userMapper.selectPage(new Page<>(page, pageSize), queryWrapper);
        return PageResult.build(pageList.getRecords(), pageList.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(User userInfo) {
        int i = userMapper.insert(userInfo);
        return i > 0;
    }

    @Override
    public boolean removeById(long id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user) > 0;
    }

}

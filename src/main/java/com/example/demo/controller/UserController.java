package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.pojo.form.user.UserAddForm;
import com.example.demo.pojo.form.user.UserQueryForm;
import com.example.demo.pojo.form.user.UserUpdateForm;
import com.example.demo.pojo.utils.JsonResult;
import com.example.demo.pojo.utils.PageResult;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangyu
 * @date 2018/12/14 11:46
 */
@RestController
@RequestMapping("user")
@Api("用户相关接口")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("add")
    public JsonResult add(@RequestBody UserAddForm userAddForm) {
        User user = new User();
        BeanUtils.copyProperties(userAddForm, user);
        userService.save(user);
        return JsonResult.ok(user);
    }

    @ApiOperation("删除用户")
    @PostMapping("delete")
    public JsonResult deleteUser(long id) {
        userService.removeById(id);
        return JsonResult.ok();
    }

    @ApiOperation("更新用户")
    @PostMapping("update")
    public JsonResult update(@RequestBody UserUpdateForm userUpdateForm) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateForm, user);
        userService.updateById(user);
        return JsonResult.ok(user);
    }

    @ApiOperation("分页查询")
    @PostMapping("list")
    public JsonResult list(@RequestBody UserQueryForm userQueryForm) {
        PageResult list = userService.selectList(userQueryForm, userQueryForm.getPage(), userQueryForm.getPageSize());
        return JsonResult.ok(list);
    }

}

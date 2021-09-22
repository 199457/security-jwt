package com.wei.sjwt.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.sjwt.model.param.BaseParam;
import com.wei.sjwt.model.param.UserParam;
import com.wei.sjwt.model.vo.UserVo;
import com.wei.sjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/info/{id}")
    public UserVo getInfo(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/test/{id}")
    public String testInterface(@PathVariable("id") String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.printf("/user/test/%s", id);
        System.out.println();
        System.out.println(authentication.toString());

        return "测试";
    }

    @PostMapping
    public void createUser(@RequestBody @Validated(UserParam.Create.class) UserParam param) {
        userService.createUser(param);
    }

    @PutMapping
    public void updateUser(@RequestBody @Validated(BaseParam.Update.class) UserParam param) {
        userService.updateUser(param);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody String[] ids) {
        userService.deleteUser(ids);
    }

    // @GetMapping
    // public Object selectUser() {
    //     return userService.selectUser();
    // }

    @GetMapping("/page/{current}/pageSize/{size}")
    public IPage<UserVo> selectUser(@PathVariable("current") int current, @PathVariable("size") int size) {
        // 设置分页
        Page<UserVo> page = new Page<>();
        page.setCurrent(current)
                .setSize(size);

        return userService.selectUser(page);
    }
}

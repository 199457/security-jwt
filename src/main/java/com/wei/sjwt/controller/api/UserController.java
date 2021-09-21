package com.wei.sjwt.controller.api;

import com.wei.sjwt.model.vo.UserVo;
import com.wei.sjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.wei.sjwt.controller.api;

import com.wei.sjwt.model.param.LoginParam;
import com.wei.sjwt.model.vo.UserVo;
import com.wei.sjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public UserVo login(@RequestBody LoginParam param) {
        return userService.login(param);
    }
}

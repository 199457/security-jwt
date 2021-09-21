package com.wei.sjwt.service;

import com.wei.sjwt.model.param.LoginParam;
import com.wei.sjwt.model.vo.UserVo;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    UserVo login(LoginParam param);

    UserVo findUserById(Long id);
}

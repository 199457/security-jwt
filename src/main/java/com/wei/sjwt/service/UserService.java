package com.wei.sjwt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.sjwt.model.entity.UserEntity;
import com.wei.sjwt.model.param.LoginParam;
import com.wei.sjwt.model.param.UserParam;
import com.wei.sjwt.model.vo.UserVo;
import org.springframework.stereotype.Component;

@Component
public interface UserService extends IService<UserEntity> {
    UserVo login(LoginParam param);

    UserVo findUserById(Long id);

    void createUser(UserParam userParam);

    void updateUser(UserParam userParam);

    void deleteUser(String[] ids);

    IPage<UserVo> selectUser(Page<UserVo> page);
}

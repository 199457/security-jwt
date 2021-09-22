package com.wei.sjwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.sjwt.model.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleService extends IService<RoleEntity> {
    void insertUserRole(Long userId, Long roleId);
}

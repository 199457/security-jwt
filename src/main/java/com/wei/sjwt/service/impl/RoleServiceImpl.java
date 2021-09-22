package com.wei.sjwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.sjwt.mapper.RoleMapper;
import com.wei.sjwt.model.entity.RoleEntity;
import com.wei.sjwt.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Override
    public void insertUserRole(Long userId, Long roleId) {
        baseMapper.insertUserRole(userId, roleId);
    }
}

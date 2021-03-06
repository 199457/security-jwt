package com.wei.sjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.sjwt.model.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    int insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
}

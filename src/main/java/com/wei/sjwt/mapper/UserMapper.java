package com.wei.sjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.sjwt.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}

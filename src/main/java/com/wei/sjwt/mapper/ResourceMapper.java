package com.wei.sjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.sjwt.model.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface ResourceMapper extends BaseMapper<ResourceEntity> {
    Set<Long> selectIdsByUserId(Long userId);
}

package com.wei.sjwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.sjwt.mapper.ResourceMapper;
import com.wei.sjwt.model.entity.ResourceEntity;
import com.wei.sjwt.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceEntity> implements ResourceService {

    @Override
    public Set<Long> getIdsByUserId(Long userId) {
        return baseMapper.selectIdsByUserId(userId);
    }
}

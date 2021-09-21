package com.wei.sjwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.sjwt.model.entity.ResourceEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface ResourceService extends IService<ResourceEntity> {
    /**
     * 根据用户id获取该用户的所有权限id
     *
     * @param userId 用户id
     * @return 权限id集合
     */
    Set<Long> getIdsByUserId(Long userId);
}

package com.wei.sjwt.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "role")
public class RoleEntity {
    private Long id;
    private String name;
}

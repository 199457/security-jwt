package com.wei.sjwt.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
// @JsonInclude(JsonInclude.Include.NON_NULL) // 空值不返回
public class UserVo {
    private Long id;
    private String username;
    private String nickname;

    private String token;
}

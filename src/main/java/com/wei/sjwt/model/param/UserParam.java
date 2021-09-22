package com.wei.sjwt.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserParam extends BaseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Long id;

    @NotBlank(message = "用户名不能为空", groups = {Create.class, Update.class})
    @Length(min = 4, max = 10, message = "用户名长度为4-10位", groups = {Create.class, Update.class})
    private String username;

    private String password;
    private String nickname;
    private String avatar;
    private Integer gender;
    private String mobile;
    private Long role;
}

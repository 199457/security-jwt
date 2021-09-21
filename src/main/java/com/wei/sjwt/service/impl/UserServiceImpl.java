package com.wei.sjwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wei.sjwt.entity.UserEntity;
import com.wei.sjwt.exception.ApiException;
import com.wei.sjwt.mapper.UserMapper;
import com.wei.sjwt.model.param.LoginParam;
import com.wei.sjwt.model.vo.UserVo;
import com.wei.sjwt.security.JwtManager;
import com.wei.sjwt.security.UserDetail;
import com.wei.sjwt.service.ResourceService;
import com.wei.sjwt.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtManager jwtManager;
    @Autowired
    private ResourceService resourceService;

    @Override
    public UserVo login(LoginParam param) {
        // 根据用户名查询出用户实体对象
        UserEntity user = userMapper.selectOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, param.getUsername()));
        // 若没有查到用户 或者 密码校验失败则抛出自定义异常
        if (user == null || !passwordEncoder.matches(param.getPassword(), user.getPassword())) {
            throw new ApiException("账号密码错误");
        }

        // 需要返回给前端的VO对象
        UserVo UserVo = new UserVo();
        UserVo.setId(user.getId())
                .setUsername(user.getUsername())
                .setNickname(user.getNickname())
                // 生成JWT，将用户名数据存入其中
                .setToken(jwtManager.generate(user.getUsername()));

        return UserVo;
    }

    @Override
    public UserVo findUserById(Long id) {
        UserEntity userEntity = userMapper.selectById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userEntity, userVo);
        return userVo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 从数据库中查询出用户实体对象
        UserEntity user = userMapper.selectOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, username));
        // 若没查询到一定要抛出该异常，这样才能被Spring Security的错误处理器处理
        if (user == null) {
            throw new UsernameNotFoundException("没有找到该用户");
        }
        // 获取权限 id 集合
        Set<SimpleGrantedAuthority> authorities = resourceService.getIdsByUserId(user.getId())
                .stream()
                .map(String::valueOf)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        // 走到这代表查询到了实体对象，那就返回自定义的UserDetail对象
        System.out.println("authorities: " + authorities);
        return new UserDetail(user, authorities);
    }
}

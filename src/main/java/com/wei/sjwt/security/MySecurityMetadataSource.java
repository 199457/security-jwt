package com.wei.sjwt.security;

import com.wei.sjwt.model.entity.ResourceEntity;
import lombok.Getter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class MySecurityMetadataSource implements SecurityMetadataSource {

    /**
     * 当前系统所有 url 资源
     */
    @Getter
    private static final Set<ResourceEntity> RESOURCES = new HashSet<>();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 该对象是Spring Security帮我们封装好的，可以通过该对象获取 request 等信息
        FilterInvocation filterInvocation = (FilterInvocation) object;
        HttpServletRequest request = filterInvocation.getRequest();
        // System.out.println("RESOURCES1: " + RESOURCES);
        // 遍历所有权限资源，以和当前请求所需的权限进行匹配
        for (ResourceEntity resource : RESOURCES) {
            // 因为我们url资源是这种格式：GET:/API/user/test/{id}，冒号前面是请求方法，冒号后面是请求路径，所以要字符串拆分
            String[] split = resource.getPath().split(":");
            // 因为/API/user/test/{id}这种路径参数不能直接equals来判断请求路径是否匹配，所以需要用Ant类来匹配
            AntPathRequestMatcher ant = new AntPathRequestMatcher(split[1]);
            // 如果请求方法和请求路径都匹配上了，则代表找到了这个请求所需的权限资源
            if (request.getMethod().equals(split[0]) && ant.matches(request)) {
                // 将我们权限资源id返回
                return Collections.singletonList(new SecurityConfig(String.valueOf(resource.getId())));
            }
        }
        // System.out.println("RESOURCES2: " + RESOURCES);
        // 走到这里就代表该请求无需授权即可访问，返回空
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

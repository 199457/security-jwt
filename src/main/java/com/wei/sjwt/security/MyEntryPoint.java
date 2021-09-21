package com.wei.sjwt.security;

import com.wei.sjwt.enums.ResultCode;
import com.wei.sjwt.model.vo.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 认证错误处理器
 */
public class MyEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(Arrays.toString(e.getStackTrace()));
        ResultVo<String> ResultVo = new ResultVo<>(ResultCode.UNAUTHORIZED, "token无效或已过期");
        out.write(ResultVo.toString());
        out.flush();
        out.close();
    }

}
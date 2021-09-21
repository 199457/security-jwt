package com.wei.sjwt.security;

import com.wei.sjwt.enums.ResultCode;
import com.wei.sjwt.model.vo.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 授权错误处理器
 */
public class MyDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResultVo<String> ResultVo = new ResultVo<>(ResultCode.FORBIDDEN, "没有相关权限");
        out.write(ResultVo.toString());
        out.flush();
        out.close();
    }
}
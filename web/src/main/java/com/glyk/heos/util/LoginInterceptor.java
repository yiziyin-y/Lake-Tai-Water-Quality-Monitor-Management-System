package com.glyk.heos.util;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

//        Object obj = request.getSession().getAttribute("loginStatus");
//            if (null == obj && !request.getRequestURI().contains("verLog")&& !request.getRequestURI().contains("heartBeat")&&!request.getRequestURI().contains("bjdwQueryPhone")&&!request.getRequestURI().contains("bjdwLogin")) { //未登录
//                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with
//                    response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
//                    System.out.println("失败的url"+request.getRequestURI());
//                    return false;
//
//                }else
//                    System.out.println("true");
//                return true;
//        }
        return super.preHandle(request, response, handler);
    }
}
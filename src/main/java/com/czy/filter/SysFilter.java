package com.czy.filter;

import com.czy.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//获取Session的过滤器
//该过滤器用来检测用户是否存在或有没有登录(登录拦截)
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //HttpServletRequest是ServletRequest的子接口，可以使用HTTP相关方法
        //向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //过滤器，从Session中获取用户
        User user = (User) request.getSession().getAttribute("user");

        if (user == null){ //已经被移除或者注销了，或者未登录
            response.sendRedirect("/LaboratoryManagementSystem/error.jsp");
        }else {
            chain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}


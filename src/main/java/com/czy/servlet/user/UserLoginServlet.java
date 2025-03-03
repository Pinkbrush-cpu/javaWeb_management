package com.czy.servlet.user;

import com.czy.pojo.Power;
import com.czy.pojo.User;
import com.czy.service.power.PowerService;
import com.czy.service.power.PowerServiceImpl;
import com.czy.service.user.UserService;
import com.czy.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//验证用户登录
public class UserLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if(user != null) {
            PowerService powerService = new PowerServiceImpl();
            Power power = powerService.loginVerify(user.getId());

            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("username", user.getUsername());

            if(power != null) {
                if (power.getPower() == 10) {
                    resp.sendRedirect("jsp/homepageManage.jsp");
                } else {
                    resp.sendRedirect("jsp/homepage.jsp");
                }
            }else{
                resp.sendRedirect("error.jsp");
            }
        } else {//查无此人，无法登录
            //转发回登录页面，顺带提示它，用户名或者密码错误；
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package com.czy.servlet.user.InformAjax;

import com.czy.pojo.User;
import com.czy.service.user.UserService;
import com.czy.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/aName")
public class InformName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String rName = (String) req.getSession().getAttribute("username");

        UserService userService = new UserServiceImpl();
        User user = userService.inForm(rName);

        if(user != null) {
            out.write(user.getUsername() + "," +
                    user.getName() + "," +
                    user.getId() + "," +
                    user.getSex() + "," +
                    user.getPhonenumber() + "," +
                    user.getEmail() + "," +
                    user.getCollege());
        } else {//查无此人，无法登录
            //转发回登录页面，顺带提示它，用户名或者密码错误；
            req.setAttribute("error","用户名或者密码不正确");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.doGet(req, resp);
    }
}

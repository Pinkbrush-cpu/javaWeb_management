package com.czy.servlet.user;

import com.czy.pojo.User;
import com.czy.service.user.UserService;
import com.czy.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用户信息显示
public class UserInformationModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取表单数据
            String name = req.getParameter("realName");
            char sex = req.getParameter("realSex").charAt(0);
            String username = req.getParameter("realUserName");
            String phone = req.getParameter("realPhone");
            String email = req.getParameter("realEmail");
            String college = req.getParameter("realCollege");

            if(sex == ' ' || name.trim().equals(" ") || username.equals(" ") || phone.equals(" ") || email.equals(" ")){
                resp.sendRedirect("jsp/information.jsp");
                return ;
            }

            UserService userService = new UserServiceImpl();
            User user = userService.inForm(String.valueOf(req.getSession().getAttribute("username")));
            User user1 = userService.inForm(username);
            if(user1 != null && user.getId() != user1.getId()){
                resp.sendRedirect("jsp/information.jsp");
                return;
            }


            if (user != null) {
                user.setName(name);
                user.setUsername(username);
                user.setSex(sex);
                user.setPhonenumber(phone);
                user.setEmail(email);
                user.setCollege(college);

                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("username", user.getUsername());

            }

        if(userService.InformModify(user)){
            resp.sendRedirect("jsp/information.jsp");
        }else{
            resp.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

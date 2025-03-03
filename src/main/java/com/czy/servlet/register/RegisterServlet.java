package com.czy.servlet.register;

import com.czy.pojo.Power;
import com.czy.pojo.User;
import com.czy.service.power.PowerService;
import com.czy.service.power.PowerServiceImpl;
import com.czy.service.register.RegisterService;
import com.czy.service.register.RegisterServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

//用户注册
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        // 获取表单数据
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        char sex = req.getParameter("sex").charAt(0);
        String phonenumber = req.getParameter("phonenumber");
        String email = req.getParameter("email");

        RegisterService registerService = new RegisterServiceImpl();
        PowerService powerService = new PowerServiceImpl();

        // 验证数据（这里应该使用更健壮的验证逻辑，比如正则表达式）
        if (name.isEmpty() || username == null || username.isEmpty() ||
                password == null || password.length() < 6 || (sex != '男' && sex != '女')|| phonenumber.isEmpty()
                || email == null || !isValidEmail(email)) {
            // 如果数据无效，重定向回注册页面并显示错误
            req.setAttribute("error", "注册失败！");
            req.getAttribute("error");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registertable.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // 检查用户名是否已存在
        boolean existingUser = registerService.findByUsername(username);
        if (existingUser) {
            req.setAttribute("error", "用户名已存在！");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registertable.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // 创建新用户并保存到数据库
        User newUser = new User();
        newUser.setName(name);
        newUser.setUsername(username);

        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);

        newUser.setPassword(hashedPassword); // 使用密码编码器加密密码
        newUser.setSex(sex);
        newUser.setPhonenumber(phonenumber);
        newUser.setEmail(email);
        newUser.setRegistrationtime(Date.from(Instant.now()));
        boolean tampUser = registerService.storageService(newUser);

        int id = registerService.getUseridService(username);

        Power newPower = new Power();
        newPower.setId(id);
        boolean tampPower = powerService.storagePowerService(newPower);

        if(!tampUser || !tampPower) {
            req.setAttribute("error", "注册失败！");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registertable.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // 重定向到首页登录
        resp.sendRedirect("index.jsp");
    }

    // 辅助方法：检查密码是否包含字母和数字
    private boolean hasLetterAndNumber(String password) {
        // ... (实现逻辑)
        return true;
    }

    // 辅助方法：验证电子邮件格式
    private boolean isValidEmail(String email) {
        // ... (可以使用正则表达式或现有的库来验证)
        return true;
    }
}
package com.czy.servlet.examination;

import com.czy.pojo.Application;
import com.czy.pojo.PublishExam;
import com.czy.pojo.User;
import com.czy.service.manager.ManagerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

//考试报名
public class ExaminationRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // 获取表单数据
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phone");
        String project = req.getParameter("project");
        String major = req.getParameter("major");

        User user = (User) req.getSession().getAttribute("user");

        ManagerServiceImpl mana = new ManagerServiceImpl();
        PublishExam pub = mana.searchExams();
        Application app = mana.searchApplication();

        Application ap = new Application();

        if (ap.getApplicationNum() <= pub.getExamMaxNum()) {
            ap.setApplicationNum(app.getApplicationNum() + 1);
        } else {
            try {
                resp.sendRedirect("error.jsp");
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ap.setExamId(pub.getExamId());
        ap.setId(user.getId());
        ap.setName(name);
        ap.setProject(project);
        ap.setPhoneNumber(phoneNumber);
        ap.setMajor(major);
        ap.setExamTime(pub.getExamTime());

        try {
            if(mana.insertApplication(ap)){
                resp.sendRedirect("error.jsp");
                return;
            }

            if (mana.storageApplication(ap)) {
                resp.sendRedirect("jsp/examination.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}

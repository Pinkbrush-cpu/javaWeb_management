package com.czy.servlet.user.examinationAjax;

import com.czy.pojo.PublishExam;
import com.czy.service.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet("/examNeed")
public class ExaminationInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        ManagerServiceImpl managerService = new ManagerServiceImpl();
        PublishExam pub = managerService.searchExams();

        Calendar calendarDead = Calendar.getInstance();
        Calendar calendarTime = Calendar.getInstance();
        calendarDead.setTime(pub.getExamDeadline());
        calendarTime.setTime(pub.getExamTime());

        out.write("<li>报名截止日期：" + calendarDead.get(Calendar.YEAR) + "年" + (calendarDead.get(Calendar.MONTH) + 1) + "月" + calendarDead.get(Calendar.DAY_OF_MONTH) + "日 " + calendarDead.get(Calendar.HOUR_OF_DAY) + "时</li>\n" +
                    "<li>考试时间；" + calendarTime.get(Calendar.YEAR) + "年" + (calendarTime.get(Calendar.MONTH) + 1) + "月" + calendarTime.get(Calendar.DAY_OF_MONTH) + "日 " + calendarTime.get(Calendar.HOUR_OF_DAY) + "时</li>\n" +
                    "<li>考试地点：" + pub.getExamLocation() + "</li>\n" +
                    "<li>所需材料：身份证，学生证等</li>");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.doGet(req, resp);
    }
}

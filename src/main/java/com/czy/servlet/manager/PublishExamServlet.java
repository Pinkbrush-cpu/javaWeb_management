package com.czy.servlet.manager;

import com.czy.pojo.PublishExam;
import com.czy.service.manager.ManagerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PublishExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取表单数据
        String examTime = req.getParameter("examTime");
        String deadline = req.getParameter("deadline");
        String examAddress = req.getParameter("examAddress");
        String maxParticipants = req.getParameter("maxParticipants");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime ex = LocalDateTime.parse(examTime, formatter);
        LocalDateTime de = LocalDateTime.parse(deadline, formatter);

        Date exDate = Date.from(ex.atZone(ZoneId.systemDefault()).toInstant());
        Date deDate = Date.from(de.atZone(ZoneId.systemDefault()).toInstant());

        PublishExam pe = new PublishExam();
        pe.setExamTime(exDate);
        pe.setExamDeadline(deDate);
        pe.setExamLocation(examAddress);
        pe.setExamMaxNum(Integer.parseInt(maxParticipants));

        ManagerServiceImpl managerService = new ManagerServiceImpl();
        boolean tampPublishExam = managerService.storagePublishExam(pe);

        if(tampPublishExam){
            if(managerService.addExam()) {
                resp.sendRedirect("jsp/PublishExam.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }
        }else{
            resp.sendRedirect("error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}

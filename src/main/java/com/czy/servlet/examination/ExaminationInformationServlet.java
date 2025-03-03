package com.czy.servlet.examination;

import com.czy.service.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayApp")
public class ExaminationInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerServiceImpl mana = new ManagerServiceImpl();
        String info = mana.recentTime();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(info);
    }

}

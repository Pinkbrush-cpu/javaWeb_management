package com.czy.servlet.examination;

import com.czy.service.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateResultsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String thExamId = req.getParameter("thExamId");
        String thId = req.getParameter("thId");
        String results = req.getParameter("results");

        if(Integer.parseInt(results) > 100 || Integer.parseInt(results) < 0){
            resp.sendRedirect("error.jsp");
            return;
        }

        ManagerServiceImpl mana = new ManagerServiceImpl();
        if(mana.updateResults(thExamId,thId,Integer.parseInt(results))){
            resp.sendRedirect("jsp/ExaminationInformation.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }

    }

}

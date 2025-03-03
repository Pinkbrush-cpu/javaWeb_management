package com.czy.dao.manager;

import com.czy.dao.BaseDao;
import com.czy.pojo.Application;
import com.czy.pojo.PublishExam;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ManagerDaoImpl implements ManagerDao{
    public boolean fillInExam(Connection con, PublishExam publishExam) {
        PreparedStatement pre = null;
        Object[] params;
        boolean tamp = false;
        String sql;
        if(con != null){
            sql = "INSERT INTO publishexam(`examTime`,`examDeadline`,`examLocation`,`examMaxNum`) values(?,?,?,?);";
            params = new Object[]{publishExam.getExamTime(), publishExam.getExamDeadline(), publishExam.getExamLocation(), publishExam.getExamMaxNum()};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                tamp = true;
            }
        }
        BaseDao.closeResource(null,pre,null);
        return tamp;
    }

    @Override
    public PublishExam informationForExam(Connection con) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        PublishExam pub = null;
        String sql = "SELECT * FROM publishexam";
        if(con != null) {
            try {
                pre = con.prepareStatement(sql);
                rs = pre.executeQuery();
                while(rs.next()){
                    LocalDate examDate = rs.getObject("examDeadline", LocalDate.class);
                    LocalTime examTime = rs.getObject("examDeadline", LocalTime.class);
                    LocalDateTime comDead = LocalDateTime.of(examDate, examTime);
                    examDate = rs.getObject("examTime", LocalDate.class);
                    examTime = rs.getObject("examTime", LocalTime.class);
                    LocalDateTime comTime = LocalDateTime.of(examDate, examTime);

                    Date deDate = Date.from(comDead.atZone(ZoneId.systemDefault()).toInstant());
                    Date tiDate = Date.from(comTime.atZone(ZoneId.systemDefault()).toInstant());
                    pub = new PublishExam();
                    pub.setExamId(rs.getInt("examId"));
                    pub.setExamDeadline(deDate);
                    pub.setExamTime(tiDate);
                    pub.setExamLocation(rs.getString("examLocation"));
                    pub.setExamMaxNum(rs.getInt("examMaxNum"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return pub;
    }

    @Override
    public boolean addForExam(Connection con) {
        PreparedStatement pre = null;
        boolean tamp = false;
        String sql;
        if(con != null){
            sql = "INSERT INTO application(`applicationNum`,`examid`,`id`,`name`,`project`,`phoneNumber`,`examTime`,`results`,`major`) values(0,0,0,'pink','java','123','2025-02-05 09:35:00','100','计算机');";
            try {
                pre = con.prepareStatement(sql);
                if(pre.executeUpdate() > 0){
                    tamp = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        BaseDao.closeResource(null,pre,null);
        return tamp;
    }

    @Override
    public Application informationForApplication(Connection con) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Application app = null;
        String sql = "SELECT * FROM application";
        if(con != null) {
            try {
                pre = con.prepareStatement(sql);
                rs = pre.executeQuery();
                while(rs.next()){
                    LocalDate appDate = rs.getObject("examTime", LocalDate.class);
                    LocalTime appTime = rs.getObject("examTime", LocalTime.class);
                    LocalDateTime comTime = LocalDateTime.of(appDate, appTime);
                    Date deDate = Date.from(comTime.atZone(ZoneId.systemDefault()).toInstant());

                    app = new Application();
                    app.setApplicationNum(rs.getInt("applicationNum"));
                    app.setExamId(rs.getInt("examId"));
                    app.setId(rs.getInt("id"));
                    app.setName(rs.getString("name"));
                    app.setProject(rs.getString("project"));
                    app.setPhoneNumber(rs.getString("phoneNumber"));
                    app.setMajor(rs.getString("major"));
                    app.setResults(rs.getInt("results"));
                    app.setExamTime(deDate);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return app;
    }

    @Override
    public boolean fillInApplication(Connection con, Application ap) {
        PreparedStatement pre = null;
        Object[] params;
        boolean tamp = false;
        String sql;
        if(con != null){
            sql = "INSERT INTO application(`applicationNum`,`examid`,`id`,`name`,`project`,`phoneNumber`,`examTime`,`results`,`major`) values(?,?,?,?,?,?,?,?,?);";
            params = new Object[]{ap.getApplicationNum(),ap.getExamId(),ap.getId(),ap.getName(),ap.getProject(),ap.getPhoneNumber(),ap.getExamTime(),ap.getResults(),ap.getMajor()};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                tamp = true;
            }
        }
        BaseDao.closeResource(null,pre,null);
        return tamp;
    }

    @Override
    public boolean insertDorApp(Connection con, Application ap) {
        PreparedStatement pre = null;
        Object[] params;
        ResultSet rs = null;
        boolean tamp = false;
        String sql;
        if(con != null){
            sql = "SELECT * FROM application WHERE id = ? AND examid = ?;";
            params = new Object[]{ap.getId(),ap.getExamId()};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            try {
                if(rs.next()) {
                    tamp = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return tamp;
    }

    @Override
    public StringBuffer latestTimeInformation(Connection con) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        StringBuffer appOut = new StringBuffer();
        String sql;
        int rowNumber = 0;
        if(con != null){
            sql = "SELECT * FROM application WHERE examTime = (SELECT MAX(examTime) FROM application);";
            try {
                pre = con.prepareStatement(sql);
                rs = pre.executeQuery();

                while (rs.next()) {
                    rowNumber++;

                    LocalDate appDate = rs.getObject("examTime", LocalDate.class);
                    LocalTime appTime = rs.getObject("examTime", LocalTime.class);
                    LocalDateTime comTime = LocalDateTime.of(appDate, appTime);
                    Date deDate = Date.from(comTime.atZone(ZoneId.systemDefault()).toInstant());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    String formattedDate = sdf.format(deDate);

                    appOut.append("<tr>" +
                            "<th id='thExamId_" + rowNumber + "'>" + rs.getInt("examId")  + "</th>" +
                            "<th id='thId_" + rowNumber + "'>" + rs.getInt("id")  + "</th>" +
                            "<th>" + rs.getString("name")  + "</th>" +
                            "<th>" + rs.getString("project")  + "</th>" +
                            "<th>" + rs.getString("phoneNumber")  + "</th>" +
                            "<th>" + rs.getString("major")  + "</th>" +
                            "<th>" + formattedDate  + "</th>" +
                            "<th><input type='text' id='results_" + rowNumber + "' value='" + rs.getInt("results") + "'/></th>" +
                            "</tr>");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return appOut;
    }

    @Override
    public boolean updateNewResults(Connection con,String thExam, String thId, int results) {
        PreparedStatement pre = null;
        Object[] params;
        boolean tamp = false;
        String sql;

        if(con != null){
            sql = "UPDATE application SET results = ? WHERE id = ? AND examid = ?;";
            params = new Object[]{results,thId,thExam};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                tamp = true;
            }
        }
        BaseDao.closeResource(null,pre,null);
        return tamp;
    }

    @Override
    public StringBuffer searchInformation(Connection con, String search) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params;
        StringBuffer appOut = new StringBuffer();
        String sql;
        int rowNumber = 0;
        if(con != null){
            sql = "SELECT * FROM application WHERE `examid` = ? OR `id` = ? OR `name` = ? OR `project` = ? OR `phoneNumber` = ?  OR `results` = ?;";
            params = new Object[]{search,search,search,search,search,search};
            try {
                rs = BaseDao.execute(con,pre,rs,sql,params);

                while (rs.next()) {
                    rowNumber++;

                    LocalDate appDate = rs.getObject("examTime", LocalDate.class);
                    LocalTime appTime = rs.getObject("examTime", LocalTime.class);
                    LocalDateTime comTime = LocalDateTime.of(appDate, appTime);
                    Date deDate = Date.from(comTime.atZone(ZoneId.systemDefault()).toInstant());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    String formattedDate = sdf.format(deDate);

                    appOut.append("<tr>" +
                            "<th id='thExamId_" + rowNumber + "'>" + rs.getInt("examId")  + "</th>" +
                            "<th id='thId_" + rowNumber + "'>" + rs.getInt("id")  + "</th>" +
                            "<th>" + rs.getString("name")  + "</th>" +
                            "<th>" + rs.getString("project")  + "</th>" +
                            "<th>" + rs.getString("phoneNumber")  + "</th>" +
                            "<th>" + rs.getString("major")  + "</th>" +
                            "<th>" + formattedDate  + "</th>" +
                            "<th><input type='text' id='results_" + rowNumber + "' value='" + rs.getInt("results") + "'/></th>" +
                            "</tr>");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return appOut;
    }
}

package com.czy.dao.manager;

import com.czy.pojo.Application;
import com.czy.pojo.PublishExam;

import java.sql.Connection;

public interface ManagerDao {
    //修改发布考试的数据库
    public boolean fillInExam(Connection con, PublishExam publishExam);

    //查询考试，并返回最后一次考试信息
    public PublishExam informationForExam(Connection con);

    //向数据库添加一个序号为0的用户
    public boolean addForExam(Connection con);

    //查询考生信息并返回最后一位考生信息
    public Application informationForApplication(Connection con);

    //插入报名考生
    public boolean fillInApplication(Connection con, Application ap);

    //查询是否有相同用户报名同一个考试
    public boolean insertDorApp(Connection con, Application ap);

    //查询数据库中最近考试时间的考生信息
    public StringBuffer latestTimeInformation(Connection con);

    //修改考试成绩
    public boolean updateNewResults(Connection con,String thExam, String thId, int results);

    //按搜索查询数据库
    public StringBuffer searchInformation(Connection con,String search);
}

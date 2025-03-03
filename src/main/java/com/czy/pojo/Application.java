package com.czy.pojo;

import java.util.Date;

public class Application {
    private int applicationNum;      //报名人数id
    private int examId;              //考试id
    private int id;
    private String name;
    private String project;          //考试科目
    private String phoneNumber;
    private Date examTime;           //考试时间
    private int results;             //考试成绩
    private String major;            //专业

    public int getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(int applicationNum) {
        this.applicationNum = applicationNum;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

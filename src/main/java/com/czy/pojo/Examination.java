package com.czy.pojo;

import java.util.Date;

public class Examination {  //考试表
    private int id;
    private String username;
    private String student_id;
    private String phonenumber;
    private String permission;
    private String state;
    private Date examtime;

    public Double getExamresults() {
        return examresults;
    }

    public void setExamresults(Double examresults) {
        this.examresults = examresults;
    }

    private Double examresults;       // 考试成绩

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }
}

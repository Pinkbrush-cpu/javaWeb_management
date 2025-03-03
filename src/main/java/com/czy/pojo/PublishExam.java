package com.czy.pojo;

import java.util.Date;

public class PublishExam {
    private int examId;
    private Date examTime;
    private Date examDeadline;
    private String examLocation;
    private int examMaxNum;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Date getExamDeadline() {
        return examDeadline;
    }

    public void setExamDeadline(Date examDeadline) {
        this.examDeadline = examDeadline;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }

    public int getExamMaxNum() {
        return examMaxNum;
    }

    public void setExamMaxNum(int examMaxNum) {
        this.examMaxNum = examMaxNum;
    }
}

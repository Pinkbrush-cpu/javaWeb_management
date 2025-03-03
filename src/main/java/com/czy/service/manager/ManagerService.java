package com.czy.service.manager;

import com.czy.pojo.Application;
import com.czy.pojo.PublishExam;

public interface ManagerService {
    //将发布的考试存入数据库
    public boolean storagePublishExam(PublishExam publishExam);

    //查询发布的考试
    public PublishExam searchExams();

    //每次发布考试向数据库中添加一个序号为0的用户
    public boolean addExam();

    //查询报名考试的用户
    public Application searchApplication();

    //将报名用户插入数据库
    public boolean storageApplication(Application ap);

    //查询数据库中是否有相同报名信息
    public boolean insertApplication(Application ap);

    //查询数据库中最近考试时间的考生信息
    public String recentTime();

    //修改成绩
    public boolean updateResults(String thExam, String thId, int results);

    //按搜索查询学生信息
    public String searchApplication(String search);
}

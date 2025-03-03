package com.czy.service.manager;

import com.czy.dao.BaseDao;
import com.czy.dao.manager.ManagerDao;
import com.czy.dao.manager.ManagerDaoImpl;
import com.czy.pojo.Application;
import com.czy.pojo.PublishExam;

import java.sql.Connection;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    //每创建一个UserServiceImpl对象都会创建一个新的UserDaoImpl对象
    public ManagerServiceImpl(){
        managerDao = new ManagerDaoImpl();
    }

    public boolean storagePublishExam(PublishExam publishExam){
        Connection con;
        boolean tamp;

        con = BaseDao.getConnect();
        tamp = managerDao.fillInExam(con,publishExam);

        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public PublishExam searchExams() {
        Connection con;

        con = BaseDao.getConnect();
        PublishExam pub = managerDao.informationForExam(con);
        BaseDao.closeResource(con,null,null);

        return pub;
    }

    @Override
    public boolean addExam() {
        Connection con;
        boolean tamp;

        con = BaseDao.getConnect();
        tamp = managerDao.addForExam(con);

        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public Application searchApplication() {
        Connection con;

        con = BaseDao.getConnect();
        Application app = managerDao.informationForApplication(con);
        BaseDao.closeResource(con,null,null);

        return app;
    }

    @Override
    public boolean storageApplication(Application ap) {
        Connection con;
        boolean tamp;

        con = BaseDao.getConnect();
        tamp = managerDao.fillInApplication(con,ap);

        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public boolean insertApplication(Application ap) {
        Connection con;
        boolean tamp;

        con = BaseDao.getConnect();
        tamp = managerDao.insertDorApp(con,ap);

        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public String recentTime() {
        Connection con;
        String s;

        con = BaseDao.getConnect();
        s = String.valueOf(managerDao.latestTimeInformation(con));

        BaseDao.closeResource(con,null,null);
        return s;
    }

    @Override
    public boolean updateResults(String thExam, String thId, int results) {
        Connection con;
        boolean tamp;

        con = BaseDao.getConnect();
        tamp = managerDao.updateNewResults(con,thExam,thId,results);

        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public String searchApplication(String search) {
        Connection con;
        String s;

        con = BaseDao.getConnect();
        s = String.valueOf(managerDao.searchInformation(con,search));

        BaseDao.closeResource(con,null,null);
        return s;
    }
}

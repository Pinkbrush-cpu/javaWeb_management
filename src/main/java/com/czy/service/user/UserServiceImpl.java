package com.czy.service.user;

import com.czy.dao.BaseDao;
import com.czy.dao.user.UserDao;
import com.czy.dao.user.UserDaoImpl;
import com.czy.pojo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    //每创建一个UserServiceImpl对象都会创建一个新的UserDaoImpl对象
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    public User login(String username,String password){
        Connection con;
        User user;

        //获取数据库连接
        con = BaseDao.getConnect();
        user = userDao.getLoginUser(con,username,password);

        //最后再关闭连接
        BaseDao.closeResource(con,null,null);
        return user;



    }

    @Override
    public User inForm(String username) {
        Connection con;
        User user;

        //获取数据库连接
        con = BaseDao.getConnect();
        user = userDao.getUserName(con,username);

        //最后再关闭连接
        BaseDao.closeResource(con,null,null);
        return user;

    }

    @Override
    public boolean InformModify(User user) {
        Connection con;
        boolean tamp = false;

        //获取数据库连接
        con = BaseDao.getConnect();
        if(user != null){
            userDao.informModify(con, user);
            tamp = true;
        }

        //最后再关闭连接
        BaseDao.closeResource(con,null,null);
        return tamp;
    }

    @Override
    public User getUserById(int id) {
        Connection con;
        User user;

        //获取数据库连接
        con = BaseDao.getConnect();
        user = userDao.getById(con,id);

        //最后再关闭连接
        BaseDao.closeResource(con,null,null);
        return user;

    }

    @Override
    public String examInfo(User user) {
        Connection con;
        String s;

        con = BaseDao.getConnect();
        s = String.valueOf(userDao.viewExamInformation(con,user));

        BaseDao.closeResource(con,null,null);
        return s;
    }
}

package com.czy.service.register;

import com.czy.dao.BaseDao;

import com.czy.dao.user.UserDao;
import com.czy.dao.user.UserDaoImpl;
import com.czy.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterServiceImpl implements RegisterService{
    private UserDao userDao;

    //每创建一个RegisterServiceImpl对象都会创建一个新的RegisterDaoImpl对象
    public RegisterServiceImpl(){
        userDao = new UserDaoImpl();
    }

    public boolean findByUsername(String username) {
        Connection con = null;
        User user = null;

        //获取数据库连接
        con = BaseDao.getConnect();
        user = userDao.getUserName(con,username);

        if(user != null){
            //最后再关闭连接
            BaseDao.closeResource(con,null,null);
            return true;
        }

        return false;

    }

    public boolean storageService(User user){
        Connection con = null;

        con = BaseDao.getConnect();
        try {
            if(userDao.fillInDatabase(con, user)){
                BaseDao.closeResource(con,null,null);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public int getUseridService(String username) {
        Connection con = null;
        int id;

        //获取数据库连接
        con = BaseDao.getConnect();
        try {
            id = userDao.getUserid(con,username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(id != 0){
            //最后再关闭连接
            BaseDao.closeResource(con,null,null);
            return id;
        }

        return 0;
    }
}

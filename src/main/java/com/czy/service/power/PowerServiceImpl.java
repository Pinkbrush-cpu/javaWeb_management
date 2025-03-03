package com.czy.service.power;

import com.czy.dao.BaseDao;
import com.czy.dao.power.PowerDao;
import com.czy.dao.power.PowerDaoImpl;
import com.czy.pojo.Power;

import java.sql.Connection;
import java.sql.SQLException;

public class PowerServiceImpl implements PowerService{
    private PowerDao powerDao;

    //每创建一个UserServiceImpl对象都会创建一个新的UserDaoImpl对象
    public PowerServiceImpl(){
        powerDao = new PowerDaoImpl();
    }

    public Power loginVerify(int id){
        Connection con = null;
        Power power = null;

        //获取数据库连接
        con = BaseDao.getConnect();
        power = powerDao.getLoginPower(con,id);

        if(power != null){
            //最后再关闭连接
            BaseDao.closeResource(con,null,null);
            return power;
        }

        return null;
    }

    @Override
    public boolean storagePowerService(Power power) {
        Connection con = null;

        con = BaseDao.getConnect();
        try {
            if(powerDao.fillInPower(con, power)){
                BaseDao.closeResource(con,null,null);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}

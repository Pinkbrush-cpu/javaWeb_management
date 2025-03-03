package com.czy.dao.power;

import com.czy.dao.BaseDao;
import com.czy.pojo.Power;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerDaoImpl implements PowerDao{
    @Override
    public Power getLoginPower(Connection con, int id) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Power power = null;
        if(con != null){
            //想要筛选的SQL语句  这里的?是一个参数占位符，它表示在执行查询之前，这个位置的值将被一个具体的值所替换。
            //这个具体的值是通过PreparedStatement对象的某个set方法
            String sql = "select * from power where id=?";

            Object[] params = {id};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            try {
                if (rs.next()){
                    power = new Power();
                    power.setId(rs.getInt("id"));
                    power.setPermission(rs.getString("permission"));
                    power.setPower(rs.getInt("power"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            BaseDao.closeResource(null,pre,rs);

        }
        return power;
    }

    @Override
    public boolean fillInPower(Connection con, Power power) throws SQLException {
        PreparedStatement pre = null;
        if(con != null){
            String sql = "insert into power(`id`,`permission`,`power`) values(?,1,1);";
            Object[] params = {power.getId()};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                BaseDao.closeResource(null,pre,null);
                return true;
            }
        }
        return false;
    }
}

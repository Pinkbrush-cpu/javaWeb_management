package com.czy.dao.power;

import com.czy.pojo.Power;
import com.czy.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface PowerDao {
    public Power getLoginPower(Connection con, int id);


    public boolean fillInPower(Connection con,Power power) throws SQLException;
}

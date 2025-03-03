package com.czy.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;


    //该代码块用来预编译和加载文件
    static {
        //Properties类用于处理配置文件的加载和存储
        Properties properties = new Properties();

        //利用反射获取文件的IO流
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("configuration.properties");

        try {
            //加载文件属性，获取文件中的键值对
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用文件中的键读取相应的值赋给变量
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("userName");
        password = properties.getProperty("password");
    }

    //获取连接
    public static Connection getConnect() {
        Connection connection = null;

        try {
            //利用反射来连接JDBC
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    //查询公共类————统一关闭
    public static ResultSet execute(Connection con, PreparedStatement pre, ResultSet rs, String sql, Object[] params) {
        try {

            //prepareStatement的作用是创建一个PreparedStatement对象，代表一条预编译的SQL语句
            pre = con.prepareStatement(sql);

            //setObject中的占位符从1开始计算，数组从0开始计算
            //占位符%代表多个字符 _代表一个字符
            for (int i = 0; i < params.length; i++) {

                //接收对象类型不确定，setObject 方法接受多种类型的参数
                //setObject作用是设置SQL 语句中的参数值，将占位符改成params[i]
                pre.setObject(i + 1, params[i]);
            }

            //executeQuery方法的作用是向数据库发送请求，并返回查询结果
            //返回的 resultSet 是一个数据表
            rs = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    //编写增删改查工具类
    public static int execute(Connection con, PreparedStatement pre, String sql, Object[] params) {
        int updateRows = 0;
        try {
            //prepareStatement的作用是创建一个PreparedStatement对象，代表一条预编译的SQL语句
            pre = con.prepareStatement(sql);

            //setObject占位符从1开始，数组从0开始
            for (int i = 0; i < params.length; i++) {

                //接收对象类型不确定，setObject 方法接受多种类型的参数
                //setObject作用是设置SQL 语句中的参数值
                pre.setObject(i + 1, params[i]);
            }
            //preparedStatement.executeUpdate()作用是执行SQL语句，并返回受影响的行数
            updateRows = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateRows;
    }


    //释放资源  必须要释放！！！
    public static boolean closeResource(Connection con, PreparedStatement pre, ResultSet rs){
        boolean flag = true;
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (pre != null) {
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}

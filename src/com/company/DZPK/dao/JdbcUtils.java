package com.company.DZPK.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Shanzhai on 2017/12/10.
 */
public class JdbcUtils {

    static String driverName = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost:3306/test";
    static String us = "root";
    static String pw = "miao";

    public static void releaseConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl,us,pw);
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch(SQLException e1){
            e1.printStackTrace();
        }
        return connection;
    }
}

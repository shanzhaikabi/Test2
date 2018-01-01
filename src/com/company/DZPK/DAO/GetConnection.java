package com.company.DZPK.dao;

import java.sql.*;

public class GetConnection {
    private Connection conn;
    private Statement stmt;
    private String databaseName;
    /*private static String stringToBase64(String ss) {
        byte[] bytes = ss.getBytes();
        String encode = Base64Util.encode(bytes);
        return encode;
    }
    public static String base64ToString(String base64) {
        byte[] decode = Base64Util.decode(base64);
        String s = new String(decode);
        return s;
    }*/
    public void doConnection(String db){
        databaseName = db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/" + db;
        try {
            conn = DriverManager.getConnection(url,    "root","");
            //创建一个Statement对象
            stmt = conn.createStatement(); //创建Statement对象
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void finalize(){
        try {
            conn.close();
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
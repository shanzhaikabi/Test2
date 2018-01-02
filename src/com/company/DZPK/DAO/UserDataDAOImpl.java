package com.company.DZPK.DAO;

import com.company.DZPK.model.UserData;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class UserDataDAOImpl implements UserDataDAO{

    Connection connection;

    @Override
    public List<UserData> GetAll() {
        try {
            List<UserData> list = new LinkedList<UserData>();
            connection = JdbcUtils.getConnection();
            String sql = "select * from user";
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int point = rs.getInt("point");
                int rank = rs.getInt("rank");
                list.add(new UserData(id,username,password,nickname,point,rank));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Save(UserData userData) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "INSERT INTO user(username, password, nickname, point, rank ,id) VALUES(?,?,?,?,?,? )";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userData.getUsername());
            pst.setString(2,userData.getPassword());
            pst.setString(3,userData.getNickname());
            pst.setInt(4,userData.getPoint());
            pst.setInt(5,userData.getRank());
            pst.setInt(6,userData.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
    }

    @Override
    public void Update(UserData userData) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "UPDATE user SET username=?, password=?, nickname=?, point=?, rank=? where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userData.getUsername());
            pst.setString(2,userData.getPassword());
            pst.setString(3,userData.getNickname());
            pst.setInt(4,userData.getPoint());
            pst.setInt(5,userData.getRank());
            pst.setInt(6,userData.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
    }

    @Override
    public UserData GetById(int id) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "select * from user where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery(sql);
            if (rs == null) return null;
            String username = rs.getString("username");
            String password = rs.getString("password");
            String nickname = rs.getString("nickname");
            int point = rs.getInt("point");
            int rank = rs.getInt("rank");
            return new UserData(id,username,password,nickname,point,rank);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public UserData GetByUsername(String username) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "select * from user where username=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,username);
            //pst.executeUpdate();
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int point = rs.getInt("point");
                int rank = rs.getInt("rank");
                return new UserData(id, username, password, nickname, point, rank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public int getNum(){
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from user";
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

package com.company.DZPK.dao;

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
    public List<UserData> getAll() {
        try {
            List<UserData> list = new LinkedList<UserData>();
            connection = JdbcUtils.getConnection();
            String sql = "select * from UserData";
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String nickname = rs.getString("nickname");
                int point = rs.getInt("point");
                int rank = rs.getInt("rank");
                list.add(new UserData(id,username,nickname,point,rank));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(UserData userData) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "INSERT INTO userdata(username, password, id, balance ,error) VALUES(?,?,?,?,? )";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userData.getUsername());
            pst.setString(2,userData.getNickname());
            pst.setInt(3,userData.getPoint());
            pst.setInt(4,userData.getRank());
            pst.setInt(5,userData.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
    }

    @Override
    public void update(UserData userData) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "UPDATE UserData SET username=?, nickname=?, point=?, rank=? where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userData.getUsername());
            pst.setString(2,userData.getNickname());
            pst.setInt(3,userData.getPoint());
            pst.setInt(4,userData.getRank());
            pst.setInt(5,userData.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
    }

    @Override
    public UserData get(int id) {
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "select * from UserData where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery(sql);
            if (rs == null) return null;
            String username = rs.getString("username");
            String nickname = rs.getString("nickname");
            int point = rs.getInt("point");
            int rank = rs.getInt("rank");
            return new UserData(id,username,nickname,point,rank);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }
}

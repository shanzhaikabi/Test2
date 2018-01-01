package com.company.DZPK.dao;

import com.company.DZPK.model.UserData;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class UserDataDAOImpl implements UserDataDAO{

    @Override
    public List<UserData> getAll() {
        try {
            Connection connection = JdbcUtils.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(UserData userData) {

    }

    @Override
    public void update(UserData userData) {

    }

    @Override
    public UserData get(String username) {
        return null;
    }
}

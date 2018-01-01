package com.company.DZPK.dao;

import com.company.DZPK.model.UserData;

import java.util.List;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public interface UserDataDAO {
    public List<UserData> getAll();

    public void save(UserData userData);

    public void update(UserData userData);

    public UserData get(int id);
}

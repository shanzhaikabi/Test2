package com.company.DZPK.dao;

import com.company.DZPK.model.UserData;

import java.util.List;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public interface UserDataDAO {
    public List<UserData> GetAll();

    public void Save(UserData userData);

    public void Update(UserData userData);

    public UserData GetById(int id);

    public UserData GetByUsername(String username);
}

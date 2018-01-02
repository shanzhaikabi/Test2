package com.company.DZPK.controller;

import com.company.DZPK.dao.DAOFactory;
import com.company.DZPK.dao.UserDataDAOImpl;
import com.company.DZPK.model.UserData;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class LoginServer {

    public static boolean CheckLogin(String username,String password){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        UserData userdata = userDataDAO.GetByUsername(username);
        if (userdata == null) return false;
        if (userdata.getPassword().equals(password)) return true;
        return false;
    }

    public static UserData getUserDataByUsername(String username){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        return userDataDAO.GetByUsername(username);
    }
}

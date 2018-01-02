package com.company.DZPK.controller;

import com.company.DZPK.dao.DAOFactory;
import com.company.DZPK.dao.UserDataDAOImpl;
import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

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

    public static void CheckLoginFromServer(String string){
        UserData usernameAndPassword = StringToAction.ActionCheckLoginByString(string);
        boolean checkLogin = CheckLogin(usernameAndPassword.getUsername(),usernameAndPassword.getPassword());
        //传给客户端
    }

    public static UserData GetUserDataByUsername(String username){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        return userDataDAO.GetByUsername(username);
    }

}

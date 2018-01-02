package com.company.DZPK.controller;

import com.company.DZPK.DAO.DAOFactory;
import com.company.DZPK.DAO.UserDataDAOImpl;
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

    public static String CheckLoginToClient(String string){
        UserData usernameAndPassword = StringToAction.ActionCheckLoginByString(string);
        boolean checkLogin = CheckLogin(usernameAndPassword.getUsername(),usernameAndPassword.getPassword());
        String returnString = ActionToString.checkLogin(checkLogin);
        return returnString;
    }

}

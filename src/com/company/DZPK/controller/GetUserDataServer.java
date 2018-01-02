package com.company.DZPK.controller;

import com.company.DZPK.DAO.DAOFactory;
import com.company.DZPK.DAO.UserDataDAOImpl;
import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

/**
 * Created by Shanzhai on 2018/1/2.
 */
public class GetUserDataServer {
    public static UserData GetUserDataByUsername(String username){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        return userDataDAO.GetByUsername(username);
    }

    public static String GetUserDataToClient(String string){
        String username = StringToAction.ActionGetUserDataByString(string);
        UserData userData = GetUserDataByUsername(username);
        String returnString = null;
        if (userData != null){
            returnString = ActionToString.GetUserData(userData);
        }
        return returnString;
    }
}

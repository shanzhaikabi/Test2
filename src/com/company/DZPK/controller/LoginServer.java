package com.company.DZPK.controller;

import com.company.DZPK.DAO.DAOFactory;
import com.company.DZPK.DAO.UserDataDAOImpl;
import com.company.DZPK.model.UserData;
import com.company.DZPK.server.*;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class LoginServer {

    public static boolean CheckLogin(String username,String password,Server.ServerThread thread){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        UserData userdata = userDataDAO.GetByUsername(username);
        if (userdata == null) return false;
        if (userdata.getPassword().equals(password)){
            Server.threadMap.put(userdata.getId(),thread);
            return true;
        }
        return false;
    }

    public static boolean Register(String username,String password){
        UserDataDAOImpl userDataDAO = DAOFactory.getUserDataDAO();
        UserData userdata = userDataDAO.GetByUsername(username);
        if (userdata == null){
            userdata = new UserData(userDataDAO.getNum() + 1,username,password,"\u65b0\u4eba\u73a9\u5bb6",0,0);
            userDataDAO.Save(userdata);
            return true;
        }
        return false;
    }

    public static String RegisterToClient(String string){
        UserData usernameAndPassword = StringToAction.ActionRegisterByString(string);
        boolean register = Register(usernameAndPassword.getUsername(),usernameAndPassword.getPassword());
        String returnString = ActionToString.Register(register);
        return returnString;
    }

    public static String CheckLoginToClient(String string, Server.ServerThread thread){
        UserData usernameAndPassword = StringToAction.ActionCheckLoginByString(string);
        boolean checkLogin = CheckLogin(usernameAndPassword.getUsername(),usernameAndPassword.getPassword(),thread);
        String returnString = ActionToString.CheckLogin(checkLogin);
        return returnString;
    }

}

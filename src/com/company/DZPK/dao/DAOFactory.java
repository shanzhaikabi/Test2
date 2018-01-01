package com.company.DZPK.dao;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class DAOFactory {
    public static UserDataDAOImpl getUserDataDAO(){
        return new UserDataDAOImpl();
    }
}

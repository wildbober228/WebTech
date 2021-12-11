package services;

import DAO.UserDAO;

import java.sql.SQLException;

public class UserService {
    private static UserDAO userDAO = new UserDAO();

    public static void registerUser(String userName, String userPassword) throws SQLException {
        userDAO.registerUser(userName, userPassword);
    }

    public static boolean loginUser(String userName, String userPassword) throws SQLException {
        return userDAO.loginUser(userName, userPassword);
    }

    public static int checkRole(String userName) throws SQLException {
        return userDAO.checkRole(userName);
    }

    public static void addApartmentToUser(String userName, int idApartment){
        userDAO.addApartmentToUser(userName,idApartment);
    }


}

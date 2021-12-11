package services;

import DAO.ApartmentDAO;
import models.Apartment;

import java.sql.SQLException;
import java.util.List;

public class ApartmentService {
    private static ApartmentDAO apartmentDAO = new ApartmentDAO();

    public ApartmentService(){

    }

    public static Apartment findApartment(int id) throws SQLException {
        return apartmentDAO.getById(id);
    }

    public static List<Apartment> findAllApartments() throws SQLException {
        return apartmentDAO.list();
    }

    public static void editApartment(String roomName, String roomCount, String roomPrice, int isBooked,int idApartment){
        apartmentDAO.updateApartment(roomName, roomCount, roomPrice, isBooked, idApartment);
    }

    public static void resetDepartmentFromUser(String userName){
        apartmentDAO.resetApartmentFromUser(userName);
    }

    public int getIdApartmentFromUser(String userName){
        return apartmentDAO.getIdApartmentFromUser(userName);
    }

    public static void bookApartment(int id){
        apartmentDAO.bookApartment(id);
    }

}

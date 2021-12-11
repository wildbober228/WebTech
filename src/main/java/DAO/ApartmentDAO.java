package DAO;

import models.Apartment;
import utils.ConnectionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

    public List<Apartment> list() throws SQLException {
        List<Apartment> listApartment = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM WebTech.apartment";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);
            while (resultSet.next()) {
                Apartment apartment = new Apartment(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
                listApartment.add(apartment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return listApartment;
    }

    public Apartment getById(int _id) throws SQLException {
        Apartment apartment = null;
        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM WebTech.apartment WHERE id = "+_id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String apartmentName = result.getString(2);
                int roomCount = result.getInt(3);
                int roomPrice = result.getInt(4);
                int isBooked = result.getInt(5);
                apartment = new Apartment(id, apartmentName, roomCount, roomPrice, isBooked);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return apartment;
    }


    public void updateApartment(String roomName, String roomCount, String roomPrice, int isBooked,int idApartment){
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET apartmentName = ?, roomCount = ?, price = ?, isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, roomName);
            pst.setString(2, roomCount);
            pst.setString(3, roomPrice);
            pst.setInt(4, isBooked);
            pst.setInt(5, idApartment);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void bookApartment(int _id){
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 1);
            pst.setInt(2, _id);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getIdApartmentFromUser(String userName) {
        int id = 0;
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "SELECT idApartment FROM WebTech.user WHERE userName = "+ "\""+ userName+ "\"";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                id = result.getInt("idApartment");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public void resetApartmentFromUser(String userName){
        int id = getIdApartmentFromUser(userName);
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void bookDeApartment(int _id){
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE WebTech.apartment SET isBooked = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setInt(2, _id);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

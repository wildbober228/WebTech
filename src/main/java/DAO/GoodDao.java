package DAO;

import models.Customer;
import models.Good;
import utils.ConnectionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {

    public void addGood(String goodName, int goodCount, float goodPrice) throws SQLException {

        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "INSERT INTO shop_bd1.goods (id,goodName,goodCount,goodPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, goodName);
            pst.setInt(3, goodCount);
            pst.setFloat(4, goodPrice);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCustomer(String goodName, String goodCount, String goodPrice,String idGood){
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE shop_bd1.goods SET goodName = ? , goodCount = ? , goodPrice = ? WHERE id = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, goodName);
            pst.setInt(2, Integer.parseInt(goodCount));
            pst.setFloat(3, Float.parseFloat(goodPrice));
            int _id = Integer.parseInt(idGood.trim());
            pst.setInt(4, _id);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Good> list() throws SQLException {
        List<Good> listGood = new ArrayList<Good>();

        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM shop_bd1.goods";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (resultSet.next()) {
                Good good = new Good(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getFloat(4));
                listGood.add(good);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return listGood;
    }

    public Good getById(int _id) throws SQLException {
        Good good = null;
        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM shop_bd1.goods WHERE id = "+_id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString(2);
                int count = result.getInt(3);
                float price = result.getFloat(4);
                good = new Good(id, name,count,price);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return good;
    }

}

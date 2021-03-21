package DAO;

import models.Customer;
import models.Discount;
import utils.ConnectionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer(String name, String surName, int FK_discount) throws SQLException {
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "INSERT INTO shop_bd1.customers (id,nameCustomer,surname,discountId) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, name);
            pst.setString(3, surName);
            pst.setInt(4, FK_discount);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCustomer(String name, String surName, int FK_discount,int idCustomer){
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "UPDATE shop_bd1.customers SET nameCustomer = ?, surname = ?, discountId = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, surName);
            pst.setInt(3, FK_discount);
            pst.setInt(4, idCustomer);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Customer> list() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM shop_bd1.customers";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                listCustomer.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return listCustomer;
    }

    public Customer getById(int _id) throws SQLException {
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM shop_bd1.customers WHERE id = "+_id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString(2);
                String surName = result.getString(3);
                int FK_discount = result.getInt(4);
                customer = new Customer(id, name,surName,FK_discount);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return customer;
    }
}


package DAO;

import models.Discount;
import utils.ConnectionData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiscountDao {

    public List<Discount> list() throws SQLException {
        List<Discount> listDiscount = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM discount ORDER BY amountDiscount";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                int amountDiscount = result.getInt("amountDiscount");
                Discount discount = new Discount(id, amountDiscount);
                listDiscount.add(discount);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return listDiscount;
    }

    public Discount getById(int _id) throws SQLException {
        Discount discount = null;
        try (Connection connection = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS)) {
            String sql = "SELECT * FROM discount WHERE id = "+_id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                int amountDiscount = result.getInt("amountDiscount");
                discount = new Discount(id, amountDiscount);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return discount;
    }

}

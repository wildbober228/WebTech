package servlets.good;

import models.Good;
import utils.ConnectionData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ListGoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Good good;
        ArrayList<Good> goods = new ArrayList<Good>();


        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);
            String sql = "SELECT * FROM shop_bd1.goods";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (resultSet.next()) {
                good = new Good(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getFloat(4));
                goods.add(good);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        req.setAttribute("goods", goods);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/good/listGood.jsp");
        requestDispatcher.forward(req, resp);
    }

}

package servlets.good;

import utils.ConnectionData;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditGoodServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        // получаем параметр id
        id = request.getParameter("id");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/good/editGood.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodName = req.getParameter("goodName");
        String goodCount = req.getParameter("goodCount");
        String goodPrice = req.getParameter("goodPrice");

        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);

            String sql = "UPDATE shop_bd1.goods SET goodName = ? , goodCount = ? , goodPrice = ? WHERE id = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, goodName);
            pst.setInt(2, Integer.parseInt(goodCount));
            pst.setFloat(3, Float.parseFloat(goodPrice));
            int _id = Integer.parseInt(id.trim());
            pst.setInt(4, _id);
            pst.executeUpdate();

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        req.setAttribute("goodName", goodName);
        doGet(req, resp);
    }

}

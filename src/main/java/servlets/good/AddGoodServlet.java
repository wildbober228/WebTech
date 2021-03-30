package servlets.good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.ConnectionData;
import utils.DataHelper;

public class AddGoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/good/addGood.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodName = req.getParameter("goodName");
        String goodCount = req.getParameter("goodCount");
        String goodPrice = req.getParameter("goodPrice");
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);

            String sql = "INSERT INTO shop_bd1.goods (id,goodName,goodCount,goodPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, goodName);
            pst.setInt(3, DataHelper.ParseToInt(goodCount));
            pst.setFloat(4, DataHelper.ParseToFloat(goodPrice));
            if (DataHelper.ParseToInt(goodCount) != -1 && DataHelper.ParseToFloat(goodPrice) != -1) {
                pst.executeUpdate();
                req.setAttribute("goodName", goodName);
            } else {
                req.setAttribute("goodName", "Error");
            }


        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        doGet(req, resp);
    }

}

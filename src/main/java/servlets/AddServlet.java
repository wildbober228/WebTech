package servlets;

import models.Model;
import models.User;

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

public class AddServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        try{
            Connection con = DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASS);

            String sql = "INSERT INTO hero.heroes (hname,password)" +
                    "VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);
            pst.executeUpdate();

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
//        User user = new User(name, password);
//        Model model = Model.getInstance();
//        model.add(user);
        req.setAttribute("userName", name);
        doGet(req, resp);
    }

}

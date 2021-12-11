package servlets.user;

import services.UserService;
import utils.ConnectionData;
import utils.DataHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/registerUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserService();
        try {
            UserService.registerUser(userName,userPassword);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        req.setAttribute("userPassword", userPassword);
        HttpSession session = req.getSession();
        session.setAttribute("sessionName", userName);
        session.setAttribute("session_role", "User");
        resp.sendRedirect("/listApartment");
    }

}

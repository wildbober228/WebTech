package servlets.customer;

import DAO.CustomerDAO;
import DAO.DiscountDao;
import models.Discount;
import utils.ConnectionData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DiscountDao dao = new DiscountDao();
            List<Discount> listDiscount = dao.list();
            req.setAttribute("listDiscount", listDiscount);

            RequestDispatcher dispatcher = req.getRequestDispatcher("views/customer/addCustomer.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("name");
        String customerSurName = req.getParameter("surname");
        String customerFK = req.getParameter("FK_discount");
        try {
            CustomerDAO dao = new CustomerDAO();

            int fk = Integer.parseInt(customerFK);

            dao.addCustomer(customerName,customerSurName,fk);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        req.setAttribute("customerName", customerName);
        doGet(req, resp);
    }

}

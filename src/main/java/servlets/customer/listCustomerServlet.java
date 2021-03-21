package servlets.customer;

import DAO.CustomerDAO;
import models.Customer;
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

public class listCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer;
        ArrayList<Customer> customers = new ArrayList<Customer>();

        CustomerDAO customerDAO = new CustomerDAO();
        try {
            customers = (ArrayList<Customer>) customerDAO.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        req.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/customer/listCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }
}

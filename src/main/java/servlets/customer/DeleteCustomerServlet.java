package servlets.customer;

import DAO.CustomerDAO;
import DAO.DiscountDao;
import models.Customer;
import models.Discount;
import utils.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteCustomerServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        CustomerDAO customerDAO = new CustomerDAO();
        int _id = DataHelper.ParseToInt(id);
        customerDAO.deleteCustomer(_id);

        Customer customer;
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try {
            customers = (ArrayList<Customer>) customerDAO.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }

}

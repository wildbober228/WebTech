package servlets.customer;

import DAO.CustomerDAO;
import DAO.DiscountDao;
import models.Discount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class EditCustomerServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        id = request.getParameter("id");
        DiscountDao dao = new DiscountDao();
        List<Discount> listDiscount = null;
        try {
            listDiscount = dao.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.setAttribute("listDiscount", listDiscount);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customer/editCustomer.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("name");
        String customerSurName = req.getParameter("surname");
        String customerFK = req.getParameter("FK_discount");
        CustomerDAO dao = new CustomerDAO();

        int fk = Integer.parseInt(customerFK);
        int _id = Integer.parseInt(id.trim());
        dao.updateCustomer(customerName,customerSurName,fk,_id);
        req.setAttribute("customerName", customerName);
        doGet(req, resp);
    }

}

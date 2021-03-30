package servlets.order;

import DAO.CustomerDAO;
import DAO.DiscountDao;
import DAO.GoodDao;
import DAO.OrderDao;
import models.Customer;
import models.Discount;
import models.Good;
import utils.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class EditOrderServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        id = request.getParameter("id");

        GoodDao goodDao = new GoodDao();
        List<Good> listGood = null;
        try {
            listGood = goodDao.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = null;
        try {
            listCustomer = customerDAO.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        request.setAttribute("listGood", listGood);
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/order/editOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fkGood = req.getParameter("FK_good");
        String fkCustomer = req.getParameter("FK_customer");
        String date = req.getParameter("orderDate");
        try {
            int FkGood = DataHelper.ParseToInt(fkGood);
            int FkCustomer = DataHelper.ParseToInt(fkCustomer);
            OrderDao orderDao = new OrderDao();
            int _id = Integer.parseInt(id.trim());
            Date date1 = DataHelper.StringToDate(date);
            if(date1 != null && FkCustomer != -1 && FkGood !=-1) {
                orderDao.updateOrder(date1, FkCustomer, FkGood, _id);
                req.setAttribute("order", date);
            }
            else{
                req.setAttribute("order", "Error");
            }

        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        doGet(req, resp);
    }

}

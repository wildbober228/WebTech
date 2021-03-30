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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            GoodDao goodDao = new GoodDao();
            List<Good> listGood = goodDao.list();
            req.setAttribute("listGood", listGood);

            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> listCustomer = customerDAO.list();
            req.setAttribute("listCustomer", listCustomer);

            RequestDispatcher dispatcher = req.getRequestDispatcher("views/order/addOrder.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fkGood = req.getParameter("FK_good");
        String fkCustomer = req.getParameter("FK_customer");
        String date = req.getParameter("orderDate");
        System.out.println("Data"+date);
        try {
            CustomerDAO customerDao = new CustomerDAO();
            GoodDao goodDao = new GoodDao();
            int FkGood = DataHelper.ParseToInt(fkGood);
            int FkCustomer = DataHelper.ParseToInt(fkCustomer);

            Customer customer = customerDao.getById(FkCustomer);
            Good good = goodDao.getById(FkGood);
            OrderDao orderDao = new OrderDao();
            Date date1 = DataHelper.StringToDate(date);
            System.out.println("Data "+date1);
            if(date1 != null|| FkCustomer != -1 || FkGood !=-1) {
                orderDao.addOrder(date1, FkCustomer, FkGood);
                req.setAttribute("order", date);
            }
            else if(date1 == null){
                req.setAttribute("order", "Error");
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        doGet(req, resp);
    }

}

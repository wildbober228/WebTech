package servlets.order;

import DAO.OrderDao;
import models.Order;
import utils.ConnectionData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ListOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order;
        ArrayList<Order> orders = new ArrayList<Order>();

        OrderDao orderDao = new OrderDao();

        try {
            orders = (ArrayList<Order>) orderDao.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        req.setAttribute("orders", orders);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/order/listOrder.jsp");
        requestDispatcher.forward(req, resp);
    }
}

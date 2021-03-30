package servlets.order;

import DAO.GoodDao;
import DAO.OrderDao;
import models.Good;
import models.Order;
import utils.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteOrderServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        OrderDao orderDao = new OrderDao();
        int _id = DataHelper.ParseToInt(id);
        orderDao.deleteOrder(_id);
        Order order;
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            orders = (ArrayList<Order>) orderDao.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        request.setAttribute("orders", orders);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/order/listOrder.jsp");
        requestDispatcher.forward(request, response);
    }


}

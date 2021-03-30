package servlets;

import DAO.DiscountDao;
import models.Discount;
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
import java.util.List;
@SuppressWarnings("unchecked")
public class testServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DiscountDao dao = new DiscountDao();
            List<Discount> listDiscount = dao.list();
            java.util.HashMap map = new java.util.HashMap();
            for (int i= 0; i < listDiscount.size(); i ++){
                map.put(i,listDiscount.get(i));
            }
            req.setAttribute("listDiscount", listDiscount);

            RequestDispatcher dispatcher = req.getRequestDispatcher("views/testSelect.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<Discount> listDiscount = (List<Discount>) req.getAttribute("listDiscount");
        String goodCount = req.getParameter("listDiscount");
        System.out.println("XXXXXXXXXXXXXXXXXX"+goodCount + "XXXXXXXXXXXXXXXXXX");
        doGet(req, resp);
    }


}

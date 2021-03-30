package servlets.good;

import DAO.CustomerDAO;
import DAO.GoodDao;
import models.Customer;
import models.Good;
import utils.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteGoodServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        GoodDao goodDao = new GoodDao();
        int _id = DataHelper.ParseToInt(id);
        goodDao.deleteGood(_id);

        Good good;
        ArrayList<Good> goods = new ArrayList<Good>();

        try {
            goods = (ArrayList<Good>) goodDao.list();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        request.setAttribute("goods", goods);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/good/listGood.jsp");
        dispatcher.forward(request, response);
    }

}

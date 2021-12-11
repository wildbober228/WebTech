package servlets.apartment;

import services.ApartmentService;
import services.UserService;
import utils.DataHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class bookApartmentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nameUser = request.getParameter("session");

        int _id = DataHelper.ParseToInt(id);
        try {
            if(UserService.checkRole(nameUser) == 0) {
                ApartmentService.resetDepartmentFromUser(nameUser);
                ApartmentService.bookApartment(_id);
                UserService.addApartmentToUser(nameUser, _id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        response.sendRedirect("/listApartment");
    }

}

package servlets.apartment;

import models.Apartment;
import services.ApartmentService;
import utils.DataHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class editApartmentServlet extends HttpServlet {

    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        response.setContentType("text/html");
        Apartment apartment = new Apartment();
        int _id = DataHelper.ParseToInt(id);
        try {
            apartment = ApartmentService.findApartment(_id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.setAttribute("apartment", apartment);
        request.setAttribute("getApartmentName", apartment.getApartmentName());
        request.setAttribute("getRoomCount", apartment.getRoomCount());
        request.setAttribute("getRoomPrice", apartment.getRoomPrice());
        request.setAttribute("getIsBooked", apartment.getIsBooked());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/apartment/editApartment.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomName = request.getParameter("roomName");
        String roomCount = request.getParameter("roomCount");
        String roomPrice = request.getParameter("roomPrice");
        String isBooked = request.getParameter("isBooked");
        int _id = DataHelper.ParseToInt(id);
        int isBook = DataHelper.ParseToInt(isBooked);
        ApartmentService.editApartment(roomName, roomCount, roomPrice, isBook, _id);

        doGet(request, response);
    }

}

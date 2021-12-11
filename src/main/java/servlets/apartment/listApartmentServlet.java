package servlets.apartment;

import models.Apartment;
import services.ApartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class listApartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApartmentService apartmentService = new ApartmentService();
        ArrayList<Apartment> apartments = null;
        try {
            apartments = (ArrayList<Apartment>) apartmentService.findAllApartments();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        req.setAttribute("apartments", apartments);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/apartment/listApartment.jsp");
        HttpSession session = req.getSession();
        req.setAttribute("session", session.getAttribute("sessionName"));
        int idApartment = apartmentService.getIdApartmentFromUser((String) session.getAttribute("sessionName"));
        try {
            Apartment apartment = apartmentService.findApartment(idApartment);
            if(apartment != null)
            req.setAttribute("apartment", apartment);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        requestDispatcher.forward(req, resp);
    }
}

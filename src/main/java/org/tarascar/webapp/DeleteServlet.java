package org.tarascar.webapp;

import org.tarascar.webapp.models.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteServlet extends HttpServlet {

    private CarService carService;

    @Override
    public void init() {
        carService = CarService.getInstance();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int number = Integer.parseInt(req.getParameter("bodyNumber"));
        carService.delCar(number);
        resp.sendRedirect("users");
    }
}

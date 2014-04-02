package org.tarascar.webapp;

import org.tarascar.webapp.models.Car;
import org.tarascar.webapp.models.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCarServlet extends HttpServlet {

    private CarService carService;

    @Override
    public void init() {
        carService = CarService.getInstance();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int bodyNumber = Integer.parseInt(req.getParameter("bodyNumber"));
        for (Car c : carService.getAll()) {
            if (c.getBodyNumber() == bodyNumber) {
                req.setAttribute("editcar", c);
            }
        }
        req.getRequestDispatcher("/editPage.jsp").forward(req, resp);

    }


}

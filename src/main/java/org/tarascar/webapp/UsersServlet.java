package org.tarascar.webapp;

import org.tarascar.webapp.models.CarService;
import org.tarascar.webapp.service.CSVWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {

    private LoginService loginService;
    private CarService carService;


    @Override
    public void init() throws ServletException {
        super.init();

        loginService = LoginService.getInstance();
        carService = CarService.getInstance();
    }


    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isAccessAllowed = (Boolean) req.getSession(true).getAttribute("isAccessAllowed");
        if (isAccessAllowed != null && isAccessAllowed) {
            req.setAttribute("cars", carService.getAll());
            CSVWriter.writeFile("D:\\MavenProjects\\simplewebcar\\src\\main\\resources\\CreateData.sql", carService.getAll());
            req.getRequestDispatcher("/cars.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

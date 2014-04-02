package org.tarascar.webapp;

import org.tarascar.webapp.models.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddCarsServlet extends HttpServlet {

    private CarService carService;

    @Override
    public void init() throws ServletException {
        super.init();
        carService = CarService.getInstance();
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("brand") == null || req.getParameter("carType") == null
                || req.getParameter("color") == null || req.getParameter("age").equals("")
                || req.getParameter("bodyNumber").equals("")) {
            throw new RuntimeException("You must fill all label");
        }

        if (carService.numberCheck(Integer.parseInt(req.getParameter("bodyNumber")))) {
            throw new RuntimeException("You must write another body number ");
        }

        Brand brand = Brand.valueOf(req.getParameter("brand"));
        CarType carType = CarType.valueOf(req.getParameter("carType"));
        Color color = Color.valueOf(req.getParameter("color"));
        int age = Integer.parseInt(req.getParameter("age"));
        int bodyNumber = Integer.parseInt(req.getParameter("bodyNumber"));

        Car car = Car.getBuilder()
                .setBrand(brand)
                .setCarType(carType)
                .setColor(color)
                .setAge(age)
                .setbodyNumber(bodyNumber).
                        build();
        carService.addCar(car);
        resp.sendRedirect("users");

    }


}

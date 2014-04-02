package org.tarascar.webapp;

import org.tarascar.webapp.CriteriaService.*;
import org.tarascar.webapp.models.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilterServlet extends HttpServlet {


    private CarService carService;

    @Override
    public void init() throws ServletException {
        super.init();
        carService = CarService.getInstance();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Filter filter = new Filter(carService);
        String brand = req.getParameter("brand");
        String carType = req.getParameter("carType");
        String color = req.getParameter("color");
        String age = req.getParameter("age");

        List<Criteria<Car>> filters = new ArrayList<Criteria<Car>>();
        if (brand != null) {
            filters.add(new BrandCriteria(Brand.valueOf(brand)));
        }
        if (carType != null) {
            filters.add(new CarTypeCriteria(CarType.valueOf(carType)));
        }
        if (color != null) {
            filters.add(new ColorCriteria(Color.valueOf(color)));
        }
        if (age != null) {
            filters.add(new AgeCriteria(Age.valueOf(age)));
        }
        AndCriteria<Car> carFilter = new AndCriteria<Car>(filters);
        req.setAttribute("cars", filter.filter(carFilter));
        req.getRequestDispatcher("/cars.jsp").forward(req, resp);

    }
}

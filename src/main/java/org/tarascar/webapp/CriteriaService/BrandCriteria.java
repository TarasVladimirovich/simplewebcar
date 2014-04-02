package org.tarascar.webapp.CriteriaService;

import org.tarascar.webapp.models.Brand;
import org.tarascar.webapp.models.Car;

public class BrandCriteria implements Criteria<Car> {

    private Brand brand;

    public BrandCriteria(Brand brand) {
        this.brand = brand;
    }

    public boolean accept(Car car) {
        return car.getBrand() == brand;
    }
}

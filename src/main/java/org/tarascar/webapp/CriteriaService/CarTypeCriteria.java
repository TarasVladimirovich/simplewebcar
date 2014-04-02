package org.tarascar.webapp.CriteriaService;

import org.tarascar.webapp.models.Car;
import org.tarascar.webapp.models.CarType;


public class CarTypeCriteria implements Criteria<Car> {

    private CarType carType;

    public CarTypeCriteria(CarType carType) {
        this.carType = carType;
    }

    public boolean accept(Car car) {
        return car.getCarType() == carType;
    }

}

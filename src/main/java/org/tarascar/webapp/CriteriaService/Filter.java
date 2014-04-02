package org.tarascar.webapp.CriteriaService;

import org.tarascar.webapp.models.Car;
import org.tarascar.webapp.models.CarService;

import java.util.HashSet;
import java.util.Set;


public class Filter {

    private final CarService service;

    public Filter(CarService service) {
        this.service = service;
    }

    public  Set<Car> filter(Criteria criteria) {
        Set<Car> filtered = new HashSet<Car>();
        for (Car car : service.getAll()) {
            if (criteria.accept(car)) {
                filtered.add(car);
            }
        }
        return filtered;
    }

}

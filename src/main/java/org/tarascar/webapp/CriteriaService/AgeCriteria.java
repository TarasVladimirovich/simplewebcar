package org.tarascar.webapp.CriteriaService;

import org.tarascar.webapp.models.Age;
import org.tarascar.webapp.models.Car;

public class AgeCriteria implements Criteria<Car> {

    private Age age;

    public AgeCriteria(Age age) {
        this.age = age;
    }

    public boolean accept(Car car) {
        return age == Age.fromValue(car.getAge()) ;
    }
}


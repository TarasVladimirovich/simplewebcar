package org.tarascar.webapp.CriteriaService;

import org.tarascar.webapp.models.Car;
import org.tarascar.webapp.models.CarType;
import org.tarascar.webapp.models.Color;

/**
 * Created by iAmater on 21.03.14.
 */
public class ColorCriteria implements Criteria<Car> {

    private Color color;

    public ColorCriteria(Color color) {
        this.color = color;
    }
    public boolean accept(Car car) {
        return car.getColor() == color;
    }
}

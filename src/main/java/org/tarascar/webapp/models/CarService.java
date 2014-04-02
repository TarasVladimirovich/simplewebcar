package org.tarascar.webapp.models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class CarService {

  //  CSVCarRead csv = new CSVCarRead("/cars.csv");
    private Set<Car> cars = new HashSet<Car>();
    private static CarService instance = new CarService();

    private CarService() {
        cars =getAll();
    }

    public static CarService getInstance() {
        return instance;
    }


    public static Set<Car> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = org.tarascar.webapp.service.Connect.getConnection();
            String s = "select * from CAR";
            preparedStatement = connection.prepareStatement(s);
            resultSet = preparedStatement.executeQuery();
            Set<Car> cars = new HashSet<Car>();
            while (resultSet.next()) {
                Car car = Car.getBuilder().
                        setBrand(Brand.valueOf(resultSet.getString("CAR_BRAND"))).
                        setCarType(CarType.valueOf(resultSet.getString("CAR_CARTYPE"))).
                        setColor(Color.valueOf(resultSet.getString("CAR_COLOR"))).
                        setAge(resultSet.getInt("CAR_AGE")).
                        setbodyNumber(resultSet.getInt("CAR_ID")).
                        build();
                cars.add(car);
            }
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void addCar(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = org.tarascar.webapp.service.Connect.getConnection();
            String s = "insert into Car(CAR_BRAND, CAR_CARTYPE, CAR_COLOR, CAR_AGE, CAR_ID) values (?, ?, ?,?, ?)";
           preparedStatement = connection.prepareStatement(s);
          preparedStatement.setString(1, car.getBrand().toString());
            preparedStatement.setString(2, car.getCarType().toString());
            preparedStatement.setString(3, car.getColor().toString());
            preparedStatement.setInt(4, car.getAge());
            preparedStatement.setInt(5, car.getBodyNumber());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public void delCar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = org.tarascar.webapp.service.Connect.getConnection();
            String s = "delete from CAR where CAR_id = ?";
            preparedStatement = connection.prepareStatement(s);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean numberCheck(int bodyNumber) {
        for (Car c : cars) {
            if ((c.getBodyNumber() == bodyNumber)) {
                return true;
            }
        }
        return false;
    }


}

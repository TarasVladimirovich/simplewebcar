package org.tarascar.webapp.models;

public class Car {

    private Brand brand;
    private CarType carType;
    private Color color;
    private int age;
    private int bodyNumber;

    public int getBodyNumber() {
        return bodyNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public CarType getCarType() {
        return carType;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    private Car(Brand brand, CarType carType, Color color, int age, int bodyNumber) {
        this.brand = brand;
        this.carType = carType;
        this.color = color;
        this.age = age;
        this.bodyNumber = bodyNumber;

    }

    public static CarBuilder getBuilder(){
        return new CarBuilder();
    }

    public static class CarBuilder{

        private Brand brand;
        private CarType carType;
        private Color color;
        private int age;
        private int bodyNumber;

        public CarBuilder setBrand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setCarType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public CarBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public CarBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public CarBuilder setbodyNumber(int bodyNumber) {
            this.bodyNumber = bodyNumber;
            return this;
        }

        public Car build(){
            return new Car(brand,carType,color,age,bodyNumber);
        }
    }


    @Override
    public String toString() {
        return "insert into Car(CAR_BRAND, CAR_CARTYPE, CAR_COLOR, CAR_AGE, CAR_ID) values ('"+brand+"', '"+carType+"" +
                "', '"+ color+"',"+age+", "+ bodyNumber+");\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (age != car.age) return false;
        if (bodyNumber != car.bodyNumber) return false;
        if (brand != car.brand) return false;
        if (carType != car.carType) return false;
        if (color != car.color) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + bodyNumber;
        return result;
    }
}

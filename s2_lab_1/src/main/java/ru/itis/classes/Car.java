package ru.itis.classes;

public class Car {
    int id_car;
    String city;
    String model;

    public Car(int id_car, String city, String model) {
        this.id_car = id_car;
        this.city = city;
        this.model = model;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

package ru.itis.classes;

public class Driver {
     String name;
     int id;
     Car car;

     public Driver(String name, int id, Car car) {
          this.name = name;
          this.id = id;
          this.car = car;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public Car getCar() {
          return car;
     }

     public void setCar(Car car) {
          this.car = car;
     }

     @Override
     public String toString() {
          return "Driver{" +
                  "name='" + name + '\'' +
                  ", id=" + id +
                  ", car=" + car +
                  '}';
     }
}

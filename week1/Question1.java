class Vehicle {
    void move() {
        System.out.println("This vehicle is moving.");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("This car is being driven on the road.");
    }
}

class ElectricCar extends Car {
    void charge() {
        System.out.println("This electric car is charging its battery.");
    }
}

public class Question1 {
    public static void main(String[] args) {
        ElectricCar myTesla = new ElectricCar();

        myTesla.move();
        myTesla.drive();
        myTesla.charge();
    }
}
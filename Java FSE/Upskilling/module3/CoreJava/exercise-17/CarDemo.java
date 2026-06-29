class Car {
    String make;
    String model;
    int year;
    
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    public void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2021);
        Car dreamCar = new Car("Porsche", "911", 2024);
        
        myCar.displayDetails();
        dreamCar.displayDetails();
    }
}
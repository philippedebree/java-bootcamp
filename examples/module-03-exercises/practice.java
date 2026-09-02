class Animal {
    String name;

    void eat() {
        System.out.println("Eating...");
    }

    void sleep(){
        System.out.println("Sleeping....");
    }
}

class Dog extends Animal{
    String breed;

    void bark(){
        System.out.println("Barking....");
    }
}

class Vehicle {
    String brand;
    Vehicle(String brand) { this.brand = brand;}
}

class Car extends Vehicle {
    int numDoors;
    Car(String brand, int numDoors){
        super(brand);
        this.numDoors = numDoors;
    }
}


public class practice {
    public static void main(String[] args){
        Vehicle vroom = new Vehicle( brand = "Toyota");
        System.out.println(Vehicle.brand);
    }
}
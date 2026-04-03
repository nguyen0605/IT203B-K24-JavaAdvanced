package entity;

public class StandardVehicle extends Vehicle {

    public StandardVehicle(String id) {
        super(id, 40, 1);
    }

    @Override
    public void move() {
        System.out.println("Car " + id + " is moving");
    }

    @Override
    public void run() {

    }
}
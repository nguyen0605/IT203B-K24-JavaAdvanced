package entity;

public class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String id) {
        super(id, 60, 10);
    }

    @Override
    public void move() {
        System.out.println("Ambulance " + id + " is moving FAST");
    }

    @Override
    public void run() {

    }
}
package entity;

public abstract class Vehicle implements Runnable {
    protected String id;
    protected int speed;
    protected int priority;

    public Vehicle(String id, int speed, int priority) {
        this.id = id;
        this.speed = speed;
        this.priority = priority;
    }

    public abstract void move();
}

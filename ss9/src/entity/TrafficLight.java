package entity;

import pattern.state.LightState;
import pattern.state.RedState;

import pattern.observer.TrafficSignal;
import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements TrafficSignal {

    private List<Vehicle> observers = new ArrayList<>();

    private LightState state;

    public TrafficLight() {
        this.state = new RedState();
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void change() {
        state.handle(this);
    }

    public String getColor() {
        return state.getColor();
    }

    @Override
    public void attach(Vehicle v) {
        observers.add(v);
    }

    @Override
    public void detach(Vehicle v) {
        observers.remove(v);
    }

    @Override
    public void notifyVehicles() {
        for (Vehicle v : observers) {
            System.out.println("Notify vehicle " + v);
        }
    }
}
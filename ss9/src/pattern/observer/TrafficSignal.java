package pattern.observer;

import entity.Vehicle;

public interface TrafficSignal {
    void attach(Vehicle v);
    void detach(Vehicle v);
    void notifyVehicles();
}
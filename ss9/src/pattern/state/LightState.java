package pattern.state;

import entity.TrafficLight;

public interface LightState {
    void handle(TrafficLight light);
    String getColor();
}
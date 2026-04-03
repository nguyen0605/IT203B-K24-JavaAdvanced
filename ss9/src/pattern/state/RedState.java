package pattern.state;

import entity.TrafficLight;

public class RedState implements LightState {

    @Override
    public void handle(TrafficLight light) {
        light.setState(new GreenState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
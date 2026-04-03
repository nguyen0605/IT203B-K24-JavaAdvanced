package pattern.state;

import entity.TrafficLight;

public class GreenState implements LightState {

    @Override
    public void handle(TrafficLight light) {
        light.setState(new YellowState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
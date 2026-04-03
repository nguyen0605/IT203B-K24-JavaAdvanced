package pattern.state;

import entity.TrafficLight;

public class YellowState implements LightState {

    @Override
    public void handle(TrafficLight light) {
        light.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
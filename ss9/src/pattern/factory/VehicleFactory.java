package pattern.factory;

import entity.*;

import java.util.Random;

public class VehicleFactory {

    private static int counter = 1;

    public static Vehicle createVehicle() {
        int type = new Random().nextInt(2);

        switch (type) {
            case 0:
                return new StandardVehicle("C" + counter++);
            case 1:
                return new PriorityVehicle("A" + counter++);
            default:
                return new StandardVehicle("C" + counter++);
        }
    }
}
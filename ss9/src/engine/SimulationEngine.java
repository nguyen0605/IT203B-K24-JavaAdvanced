package engine;

import entity.Vehicle;
import pattern.factory.VehicleFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            Vehicle v = VehicleFactory.createVehicle();
            pool.submit(v);
        }

        pool.shutdown();
    }
}
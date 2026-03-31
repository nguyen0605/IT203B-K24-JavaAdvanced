package btkha2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor adapter = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade home = new SmartHomeFacade(adapter);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    home.getCurrentTemperature();
                    break;
                case 2:
                    home.leaveHome();
                    break;
                case 3:
                    home.sleepMode();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
package btkha1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    HardwareConnection.getInstance();
                    break;

                case 2:
                    System.out.println("Chọn loại:");
                    System.out.println("1. Đèn");
                    System.out.println("2. Quạt");
                    System.out.println("3. Điều hòa");

                    int type = sc.nextInt();
                    DeviceFactory factory = null;

                    switch (type) {
                        case 1: factory = new LightFactory(); break;
                        case 2: factory = new FanFactory(); break;
                        case 3: factory = new AirConditionerFactory(); break;
                        default:
                            System.out.println("Không hợp lệ!");
                            continue;
                    }

                    Device device = factory.createDevice();
                    devices.add(device);
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    System.out.print("Chọn thiết bị (1 -> " + devices.size() + "): ");
                    int onIndex = sc.nextInt() - 1;

                    if (onIndex >= 0 && onIndex < devices.size()) {
                        devices.get(onIndex).turnOn();
                    } else {
                        System.out.println("Không hợp lệ!");
                    }
                    break;

                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    System.out.print("Chọn thiết bị (1 -> " + devices.size() + "): ");
                    int offIndex = sc.nextInt() - 1;

                    if (offIndex >= 0 && offIndex < devices.size()) {
                        devices.get(offIndex).turnOff();
                    } else {
                        System.out.println("Không hợp lệ!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}

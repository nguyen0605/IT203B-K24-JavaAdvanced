package btkha1;

public abstract class DeviceFactory {
    public abstract Device createDevice();
}

class Light implements Device {
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Quạt: Quay.");
    }

    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}

class AirConditioner implements Device {
    public void turnOn() {
        System.out.println("Điều hòa: Làm mát.");
    }

    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}



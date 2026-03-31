package btkha2;

class Light {
    void off() {
        System.out.println("FACADE: Tắt đèn");
    }
}

class Fan {
    void off() {
        System.out.println("FACADE: Tắt quạt");
    }

    void lowSpeed() {
        System.out.println("FACADE: Quạt chạy tốc độ thấp");
    }
}

class AirConditioner {
    void off() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    void setTemperature(int temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }
}

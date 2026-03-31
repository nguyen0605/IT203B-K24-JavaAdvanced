package btkha1;

public class HardwareConnection {
    private static HardwareConnection instance = new HardwareConnection();

    private HardwareConnection() {
    }

    public static HardwareConnection getInstance(){
        System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        return instance;
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Ngắt kết nối.");
    }
}

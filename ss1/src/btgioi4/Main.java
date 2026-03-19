package btgioi4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UserProcessor.processUserData();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy");
    }
}

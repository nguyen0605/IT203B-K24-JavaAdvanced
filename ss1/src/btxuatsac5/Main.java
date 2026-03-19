package btxuatsac5;

public class Main {
    public static void main(String[] args) {
        btxuatsac5.User userA = new User();

        try {
            userA.setAge(-2);
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục...");
    }
}

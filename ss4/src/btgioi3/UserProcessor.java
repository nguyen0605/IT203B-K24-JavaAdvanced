package btgioi3;

public class UserProcessor {

    public String processEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        // kiểm tra có @
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String[] parts = email.split("@");

        // kiểm tra có tên miền
        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // chuẩn hóa lowercase
        return email.toLowerCase();
    }
}

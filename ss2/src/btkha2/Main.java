package btkha2;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = password -> password.length() >= 8;

        System.out.println(validator.isValid("12345678")); // true
        System.out.println(validator.isValid("1234"));     // false
    }
}

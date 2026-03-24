package btgioi4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void evaluatePasswordStrength() {

        assertAll("Password Strength Tests",

                () -> assertEquals("Mạnh",
                        userService.evaluatePasswordStrength("Abc123!@")),

                () -> assertEquals("Trung bình",
                        userService.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung bình",
                        userService.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung bình",
                        userService.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        userService.evaluatePasswordStrength("Abc12345")),

                () -> assertEquals("Yếu",
                        userService.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yếu",
                        userService.evaluatePasswordStrength("password")),

                () -> assertEquals("Yếu",
                        userService.evaluatePasswordStrength("ABC12345"))
        );
    }
}
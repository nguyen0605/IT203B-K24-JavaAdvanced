package btkha1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    private final UserValidator validator = new UserValidator();

    @Test
    void testValidUsername() {
        // Arrange
        String username = "user123";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    // TC02: abc -> quá ngắn
    @Test
    void testUsernameTooShort() {
        // Arrange
        String username = "abc";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    // TC03: user name -> chứa khoảng trắng
    @Test
    void testUsernameContainsSpace() {
        // Arrange
        String username = "user name";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}

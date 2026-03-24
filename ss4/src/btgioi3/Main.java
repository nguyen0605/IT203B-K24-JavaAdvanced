package btgioi3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Main {
    private UserProcessor userProcessor;

    @BeforeEach
    void setUp(){
        userProcessor = new UserProcessor();
    }

    @Test
    void shouldReturnSameEmail_whenEmailIsValid(){
        String email = "user@gmail.com";

        String result = userProcessor.processEmail(email);

        assertEquals(email, result);
    }

    @Test
    void shouldThrowException_whenEmailMissingAtSymbol() {
        // Arrange
        String email = "usergmail.com";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail(email);
        });
    }

    // ❌ Có @ nhưng thiếu domain
    @Test
    void shouldThrowException_whenEmailMissingDomain() {
        // Arrange
        String email = "user@";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail(email);
        });
    }

    // 🔥 Chuẩn hóa lowercase
    @Test
    void shouldConvertToLowercase_whenEmailHasUppercase() {
        // Arrange
        String email = "Example@Gmail.com";

        // Act
        String result = userProcessor.processEmail(email);

        // Assert
        assertEquals("example@gmail.com", result);
    }
}

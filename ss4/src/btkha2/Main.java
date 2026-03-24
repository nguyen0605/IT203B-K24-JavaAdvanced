package btkha2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Main {
    private final UserService userService = new UserService();

    @Test
    public void testAgeEquals18(){
        int age = 18;

        boolean result = userService.checkRegistrationAge(age);

        assertEquals(true, result);
    }

    @Test
    public void testAgeBelow18(){
        int age = 17;

        boolean result = userService.checkRegistrationAge(age);

        assertEquals(false, result);
    }

    @Test
    public void testAgeNegative(){
        int age = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            userService.checkRegistrationAge(age);
        });
    }
}

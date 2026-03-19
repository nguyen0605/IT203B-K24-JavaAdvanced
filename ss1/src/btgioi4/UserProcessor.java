package btgioi4;

import java.io.IOException;

public class UserProcessor {
    public static void processUserData() throws IOException{
        UserService.saveToFile();
    }
}

package btgioi3;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> userOpt = repo.findUserByUsername("alice");

        String message = userOpt
                .map(user -> "Welcome " + user.username())
                .orElse("Guest Login");

        System.out.println(message);
    }
}

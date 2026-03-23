package btxuatsac5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alex"),
                new User("alexander"),
                new User("bob"),
                new User("charlotte"),
                new User("benjamin"),
                new User("tom")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User user) -> user.getUsername().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.getUsername()));

    }
}

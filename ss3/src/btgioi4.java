import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record User(String username, String email){}

public class btgioi4 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com"),
                new User("bob", "bob@gmail.com"),
                new User("charlie", "charlie@gmail.com"),
                new User("alice", "alice1@gmail.com")
        );

        List<User> result = new ArrayList<>(
                users.stream()
                        .collect(Collectors.toMap(
                                User::username,
                                user -> user,
                                (u1, u2) -> u1
                        ))
                        .values()
        );

        result.forEach(System.out::println);
    }
}

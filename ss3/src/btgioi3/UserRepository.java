package btgioi3;

import java.util.List;
import java.util.Optional;

record User(String username, String email){}

public class UserRepository {
    List<User> users = List.of(
            new User("alice", "alice@gmail.com"),
            new User("bob", "bob@gmail.com"),
            new User("charlie", "charlie@gmail.com")
    );

    public Optional<User> findUserByUsername(String username){
        return users.stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
    }
}

package btgioi4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("an"),
                new User("binh"),
                new User("cuong")
        );

        Function<User, String> getName = User::getUsername;

        // 3. Method Reference: System.out::println
        Consumer<String> print = System.out::println;

        // 4. Method Reference: User::new
        Supplier<User> createUser = User::new;

        // ===== TEST =====

        // Lấy username và in
        users.stream()
                .map(getName)
                .forEach(print);

        // Tạo user mới
        User u = createUser.get();
        System.out.println(u.getUsername());
    }
}

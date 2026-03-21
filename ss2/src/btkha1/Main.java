package btkha1;

import java.beans.Customizer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<User> newUser = () -> new User("sv01", "nguyen van a", 20, Role.ADMIN);

        Predicate<User> isAdmin = user -> Role.ADMIN.equals(user.getRole());

        Function<User, String> getUsername = user -> user.getName();

        Consumer<User> printUser = user -> System.out.println(user);

        printUser.accept(newUser.get());
    }
}

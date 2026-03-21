package btkha1;

public class User {
    private String id;
    private String name;
    private int age;
    private Role role;

    public User(String id, String name, int age, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }
}

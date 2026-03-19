package btxuatsac6;

public class User {
    private int age;
    private String name;

    public void setAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public void printInfo() {
        if (name != null) {
            System.out.println("Tên: " + name);
        }
        System.out.println("Tuổi: " + age);
    }
}

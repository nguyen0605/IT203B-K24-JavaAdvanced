package btkha2;

public class UserService {
    public boolean checkRegistrationAge(int age){
        if (age <= 0){
            throw new IllegalArgumentException("Số truyền vào phải lớn hơn không");
        }

        return age >= 18;
    }
}

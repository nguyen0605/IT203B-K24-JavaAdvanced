package btgioi3;

public class Main {
    public static void main(String[] args) {
        User userA = new User();

        try {
            userA.setAge(-5);
        } catch (IllegalArgumentException e){
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục ... ");
    }
}

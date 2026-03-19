import java.util.Scanner;

public class btkha2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập vào tổng số người dùng: ");
            int userCount = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập vào số lượng nhóm: ");
            int groupCount = Integer.parseInt(sc.nextLine());

            int result = userCount/groupCount;
            System.out.println("Mỗi nhóm có " + result + " người");

        } catch (ArithmeticException e){
            System.out.println("Không thể chia cho 0!");

        } catch (NumberFormatException e){
            System.out.println("Vui lòng nhập số hợp lệ!");
        } finally {
            sc.close();
            System.out.println("Đã đóng scanner");
        }

        System.out.println("Chương trình tiếp tục chạy");
    }
}

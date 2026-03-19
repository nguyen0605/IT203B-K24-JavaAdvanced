import java.util.Scanner;

public class btkha1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập vào năm sinh của bạn: ");
            String dob = sc.nextLine();

            int namsinh = Integer.parseInt(dob);

            int tuoi = 2026 - namsinh;
            System.out.print("Tuổi của bạn là: "  + tuoi);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập số hợp lệ (ví dụ 2005)");
        } finally {
            sc.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}

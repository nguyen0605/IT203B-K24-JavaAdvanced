import strategy.BonusSalary;
import strategy.FixedSalary;
import strategy.HourlySalary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeBusiness employeeBusiness = EmployeeBusiness.getInstance();

        while (true){
            System.out.println("\n1. Thêm");
            System.out.println("2. Hiển thị");
            System.out.println("3. Lương > X");
            System.out.println("4. Lọc phòng ban");
            System.out.println("5. Tăng lương");
            System.out.println("6. Xóa lương thấp");
            System.out.println("7. Sắp xếp");
            System.out.println("8. Thống kê");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1: {
                    Employee e = EmployeeFactory.create(sc);

                    System.out.println("1. Lương cứng");
                    System.out.println("2. Lương + thưởng");
                    System.out.println("3. Lương giờ");
                    int type = Integer.parseInt(sc.nextLine());

                    if(type == 1) e.setStrategy(new FixedSalary());
                    else if(type == 2) e.setStrategy(new BonusSalary());
                    else e.setStrategy(new HourlySalary());

                    employeeBusiness.addEmp(e);
                    break;
                }

                case 2: {
                    employeeBusiness.display();
                    break;
                }

                case 3: {
                    System.out.print("Nhập X: ");
                    employeeBusiness.findEmpBySalary(Double.parseDouble(sc.nextLine()));
                    break;
                }

                case 4:{
                    System.out.print("Nhập phòng ban: ");
                    employeeBusiness.filterDept(sc.nextLine());
                    break;
                }

                case 5: {
                    System.out.print("Nhập %: ");
                    employeeBusiness.increaseSalary(Double.parseDouble(sc.nextLine()));
                    break;
                }

                case 6: {
                    System.out.print("Nhập X: ");
                    employeeBusiness.deleteBySalary(Double.parseDouble(sc.nextLine()));
                    break;
                }

                case 7: {
                    employeeBusiness.sortBySalary();
                    break;
                }

                case 8: {
                    employeeBusiness.statistic();
                    break;
                }

                case 0:{
                    return;
                }
            }
        }
    }
}

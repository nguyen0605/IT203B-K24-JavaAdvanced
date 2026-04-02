import strategy.SalaryStrategy;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    private String empId;
    private String empName;
    private double salary;
    private String department;
    private LocalDate joinDate;
    private SalaryStrategy strategy;

    public Employee() {
    }

    public Employee(String empId, String empName, double salary, String department, LocalDate joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.department = department;
        this.joinDate = joinDate;
    }

    public void inputData(Scanner sc){
        while (true){
            System.out.print("Nhập id nhân viên (NVxxx): ");
            empId = sc.nextLine();
            if (empId.matches("NV\\d{3}")) break;
            System.out.println("Sai định dạng, vui lòng nhập lại!");
        }

        do {
            System.out.print("Nhập tên nhân viên: ");
            empName = sc.nextLine();
        } while (empName.trim().isEmpty());

        while (true){
            System.out.print("Nhập lương: ");
            salary = Double.parseDouble(sc.nextLine());
            if (salary > 0 ) break;
            System.out.println("Lương phải lớn hơn 0");
        } while (salary <= 0);

        while (true){
            System.out.print("Phòng ban (IT/HR/Sales): ");
            department = sc.nextLine();
            if (department.matches("IT|HR|Sales")) break;
            System.out.println("Nhập sai phòng ban, vui lòng nhập lại");
        }

        while (true){
            System.out.println("Nhập ngày vào làm (yyyy-mm-dd): ");
            joinDate = LocalDate.parse(sc.nextLine());
            if (joinDate.isBefore(LocalDate.now())) break;
            System.out.println("Ngày không hợp lệ!");
        }
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public double calculateSalary(){
        return strategy.calculate(salary);
    }

    public void setStrategy(SalaryStrategy strategy){
        this.strategy = strategy;
    }

    public void increase(double percent){
        salary *= (1 + percent/100);
    }

    public void displayInfo(){
        System.out.printf("\n%s | %s | %.2f | %s | %s",
                empId, empName, salary, department, joinDate);
    }
}

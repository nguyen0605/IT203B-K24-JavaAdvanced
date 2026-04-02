import java.util.Scanner;

public class EmployeeFactory {
    public static Employee create(Scanner sc){
        Employee e = new Employee();
        e.inputData(sc);
        return e;
    }
}

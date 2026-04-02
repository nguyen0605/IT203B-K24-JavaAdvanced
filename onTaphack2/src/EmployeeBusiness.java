import java.util.*;

public class EmployeeBusiness {
    private static EmployeeBusiness instance;
    private List<Employee> list = new ArrayList<>();

    private EmployeeBusiness() {}

    public static EmployeeBusiness getInstance() {
        if (instance == null){
            instance = new EmployeeBusiness();
        }
        return instance;
    }

    public void addEmp(Employee e){
        for (Employee emp : list){
            if (emp.getEmpId().equals(e.getEmpId())){
                System.out.println("Trùng ID!");
                return;
            }
        }
        list.add(e);
    }

    public void display(){
        if (list.isEmpty()){
            System.out.print("Danh sách rỗng!");
            return;
        }
        list.forEach(Employee::displayInfo);
    }

    public void findEmpBySalary(double x){
        list.stream()
                .filter(employee -> employee.getSalary() > x)
                .forEach(Employee::displayInfo);
    }

    public void filterDept(String dept){
        list.stream()
                .filter(employee -> employee.getDepartment().equals(dept))
                .forEach(Employee::displayInfo);
    }

    public void increaseSalary(double percent){
        list.forEach(employee -> employee.increase(percent));
    }

    public void deleteBySalary(double x){
        list.removeIf(employee -> employee.getSalary() < x);
    }

    public void sortBySalary(){
        list.sort(Comparator.comparingDouble(Employee::getSalary));
    }

    public void statistic(){
        Map<String, Integer> map = new HashMap<>();

        for (Employee e : list){
            map.put(e.getDepartment(), map.getOrDefault(e.getDepartment(), 0) + 1);
        }

        System.out.println(map);
    }
}

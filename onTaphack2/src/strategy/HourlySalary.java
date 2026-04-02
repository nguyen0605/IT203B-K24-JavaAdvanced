package strategy;

public class HourlySalary implements SalaryStrategy{
    @Override
    public double calculate(double base) {
        return base * 8;
    }
}

package strategy;

public class FixedSalary implements SalaryStrategy{
    @Override
    public double calculate(double base) {
        return base;
    }
}

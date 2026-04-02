package strategy;

public class BonusSalary implements SalaryStrategy{
    @Override
    public double calculate(double base) {
        return base * 1.2;
    }
}

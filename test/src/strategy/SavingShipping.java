package strategy;

public class SavingShipping implements ShippingStrategy {
    public double calculate(double amount) {
        return amount * 0.02;
    }
}

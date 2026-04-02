package strategy;

public class NormalShipping implements ShippingStrategy {
    public double calculate(double amount) {
        return amount * 0.05;
    }
}
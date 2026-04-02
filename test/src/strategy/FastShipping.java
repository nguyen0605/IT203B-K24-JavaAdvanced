package strategy;

public class FastShipping implements ShippingStrategy {
    public double calculate(double amount) {
        return amount * 0.1;
    }
}

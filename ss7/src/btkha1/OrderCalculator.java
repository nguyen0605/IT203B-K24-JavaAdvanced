package btkha1;

class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;

        for (var entry : order.getItems().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }
}
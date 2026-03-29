package btgioi3;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        // COD
        PaymentMethod cod = new CODPayment();
        processor.process(cod, 500000);

        // Credit Card
        PaymentMethod card = new CreditCardPayment();
        processor.process(card, 1000000);

        // MoMo
        PaymentMethod momo = new MomoPayment();
        processor.process(momo, 750000);

        // 🔥 Kiểm tra LSP
        PaymentMethod method = new CreditCardPayment();
        processor.process(method, 1000000);

        // thay bằng Momo (không sửa processor)
        method = new MomoPayment();
        processor.process(method, 1000000);
    }
}

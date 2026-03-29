package btgioi3;

public class CreditCardPayment implements CardPayable{
    @Override
    public void payByCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");
    }
}

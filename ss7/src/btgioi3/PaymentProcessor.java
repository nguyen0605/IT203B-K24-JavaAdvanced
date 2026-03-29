package btgioi3;

public class PaymentProcessor {
    public void process(PaymentMethod method, double amount){
        if (method instanceof CODPayable cod){
            cod.payCOD(amount);
        } else if (method instanceof CardPayable card) {
            card.payByCard(amount);

        } else if (method instanceof EWalletPayable wallet) {
            wallet.payByEWallet(amount);

        } else {
            throw new IllegalArgumentException("Phương thức không hỗ trợ");
        }
    }
}

package btgioi3;

class MomoPayment implements EWalletPayable {

    @Override
    public void payByEWallet(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");
    }
}
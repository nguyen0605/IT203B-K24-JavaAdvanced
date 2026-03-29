package btgioi3;

public class CODPayment implements CODPayable{
    @Override
    public void payCOD(double amount) {
        System.out.println("Xử lý thanh toán COD: " + amount + " - Thành công");
    }
}

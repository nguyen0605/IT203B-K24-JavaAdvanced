package btkha1;

public class TicketSupplier implements Runnable {

    private TicketPool roomA;
    private TicketPool roomB;
    private int supplyCount; // số vé thêm mỗi lần
    private int interval;    // thời gian chờ (ms)
    private int rounds;      // số lần thêm

    public TicketSupplier(TicketPool roomA, TicketPool roomB,
                          int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        for (int i = 1; i <= rounds; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            roomA.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng A");

            roomB.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng B");
        }

        System.out.println("Nhà cung cấp kết thúc.");
    }
}

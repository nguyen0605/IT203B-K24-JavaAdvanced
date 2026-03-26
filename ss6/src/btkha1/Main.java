package btkha1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Tạo vé ban đầu
        List<Ticket> listA = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listA.add(new Ticket("A-" + String.format("%03d", i), "A"));
        }

        List<Ticket> listB = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listB.add(new Ticket("B-" + String.format("%03d", i), "B"));
        }

        TicketPool roomA = new TicketPool("A", listA);
        TicketPool roomB = new TicketPool("B", listB);

        // 2 quầy bán
        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB);

        // Supplier (3 giây = 3000ms)
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 3);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Tổng kết
        System.out.println("\n=== Kết thúc chương trình ===");
        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount());
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount());

        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());
    }
}

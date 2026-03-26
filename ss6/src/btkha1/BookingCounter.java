package btkha1;

import java.util.Random;

public class BookingCounter implements Runnable{
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        while (roomA.getRemainingTickets() > 0 && roomB.getRemainingTickets() > 0){
            TicketPool chosenRoom = random.nextBoolean() ? roomA : roomB;

            Ticket ticket = chosenRoom.sellTicket();

            if (ticket != null){
                System.out.println(counterName + " bán vé phòng " + chosenRoom.getRoomName());
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSoldCount() {
        return soldCount;
    }
}

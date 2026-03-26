package btkha1;

import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;

    public TicketPool(String roomName, List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }

    public synchronized Ticket sellTicket(){
        for (Ticket ticket : tickets){
            if (!ticket.isSold()){
                ticket.setSold(true);
                return ticket;
            }
        }
        return null;
    }

    public long getRemainingTickets(){
        return tickets.stream().filter(ticket -> !ticket.isSold()).count();
    }

    public String getRoomName() {
        return roomName;
    }

    public synchronized void addTickets(int count) {
        int currentSize = tickets.size();

        for (int i = 1; i <= count; i++) {
            String id = roomName + "-" + String.format("%03d", currentSize + i);
            tickets.add(new Ticket(id, roomName));
        }
    }
}

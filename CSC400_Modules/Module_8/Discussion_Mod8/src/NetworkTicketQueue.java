import java.util.LinkedList;
import java.util.Queue;

public class NetworkTicketQueue {
    public static void main(String[] args) {
        Queue<String> tickets = new LinkedList<>();

        tickets.offer("Configure new switch");
        tickets.offer("Investigate slow connection");
        tickets.offer("Review interface errors");

        System.out.println("Tickets waiting: " + tickets);
        System.out.println("Next ticket: " + tickets.peek());

        while (!tickets.isEmpty()) {
            System.out.println("Processing: " + tickets.poll());
        }

        System.out.println("Queue empty: " + tickets.isEmpty());
    }
}

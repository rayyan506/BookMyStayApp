import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    /** Queue that stores booking requests */
    private Queue<Reservation> requestQueue;

    /** Initializes empty queue */
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /** Add booking request */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /** Get next request (FIFO) */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /** Check if requests exist */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();  // ✅ FIXED
    }
}
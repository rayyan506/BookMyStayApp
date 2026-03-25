public class ConcurrentBookingProcessor implements Runnable {

    /** Shared booking queue */
    private BookingRequestQueue bookingQueue;

    /** Shared inventory */
    private RoomInventory inventory;

    /** Shared allocation service */
    private RoomAllocationService allocationService;

    /**
     * Constructor
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Thread execution logic
     */
    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break; // Exit when no more requests
                }

                reservation = bookingQueue.getNextRequest();
            }


            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}
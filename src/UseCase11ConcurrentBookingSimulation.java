import java.util.HashMap;
import java.util.Map;

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        // Setup inventory
        Map<String, Integer> availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);

        RoomInventory inventory = new RoomInventory(availability);

        // Setup booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        // Allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        // Start threads
        t1.start();
        t2.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Final inventory
        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry :
                inventory.getRoomAvailability().entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
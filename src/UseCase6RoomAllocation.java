public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Inventory setup
        java.util.Map<String, Integer> availability = new java.util.HashMap<>();
        availability.put("Single", 2);
        availability.put("Suite", 1);

        RoomInventory inventory = new RoomInventory(availability);

        // Queue setup (from Use Case 5)
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Process queue FIFO
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocationService.allocateRoom(r, inventory);
        }
    }
}
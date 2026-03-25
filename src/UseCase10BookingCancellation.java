import java.util.HashMap;
import java.util.Map;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Setup inventory
        Map<String, Integer> availability = new HashMap<>();
        availability.put("Single", 5); // before cancellation

        RoomInventory inventory = new RoomInventory(availability);

        // Initialize service
        CancellationService service = new CancellationService();

        // Simulate confirmed booking (from Use Case 6)
        String reservationId = "Single-1";
        service.registerBooking(reservationId, "Single");

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated inventory
        System.out.println("Updated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}
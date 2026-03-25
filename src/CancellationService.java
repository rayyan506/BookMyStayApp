import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    /** Stack to store released room IDs (LIFO rollback tracking) */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID → room type */
    private Map<String, String> reservationRoomTypeMap;

    /** Constructor */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Register confirmed booking
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancel booking and restore inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid reservation ID. Cannot cancel.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        availability.put(roomType, availability.get(roomType) + 1);

        // Track rollback
        releasedRoomIds.push(reservationId);

        // Remove booking record
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Show rollback history (LIFO)
     */
    public void showRollbackHistory() {

        System.out.println("Rollback History (Most Recent First):");

        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}
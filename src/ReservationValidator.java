import java.util.Map;

public class ReservationValidator {

    /**
     * Validate booking input
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type (CASE SENSITIVE)
        if (!roomType.equals("Single") &&
                !roomType.equals("Double") &&
                !roomType.equals("Suite")) {

            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Validate availability
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType) ||
                availability.get(roomType) <= 0) {

            throw new InvalidBookingException("Selected room type is not available.");
        }
    }
}
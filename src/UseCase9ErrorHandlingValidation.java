import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Setup inventory
        Map<String, Integer> availability = new HashMap<>();
        availability.put("Single", 2);
        availability.put("Double", 2);
        availability.put("Suite", 1);

        RoomInventory inventory = new RoomInventory(availability);

        // Initialize components
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // User input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(guestName, roomType, inventory);

            // If valid → add to queue
            Reservation reservation = new Reservation(guestName, roomType);
            bookingQueue.addRequest(reservation);

            System.out.println("Booking request added successfully!");

        } catch (InvalidBookingException e) {

            // Handle validation errors
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
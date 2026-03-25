import java.util.Map;

public class RoomSearchService {

    /**
     * Displays available rooms along with their details and pricing.
     * This method performs read-only access to inventory and room data.
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search");

        // Single Room
        if (availability.get("Single") != null && availability.get("Single") > 0) {
            System.out.println("\nSingle Room:");
            displayRoomDetails(singleRoom, availability.get("Single"));
        }

        // Double Room
        if (availability.get("Double") != null && availability.get("Double") > 0) {
            System.out.println("\nDouble Room:");
            displayRoomDetails(doubleRoom, availability.get("Double"));
        }

        // Suite Room
        if (availability.get("Suite") != null && availability.get("Suite") > 0) {
            System.out.println("\nSuite Room:");
            displayRoomDetails(suiteRoom, availability.get("Suite"));
        }
    }

    private void displayRoomDetails(Room room, int available) {
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available: " + available);
    }
}
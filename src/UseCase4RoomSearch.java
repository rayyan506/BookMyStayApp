import java.util.HashMap;
import java.util.Map;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Create Room objects
        Room singleRoom = new Room(1, 250, 1500.0);
        Room doubleRoom = new Room(2, 400, 2500.0);
        Room suiteRoom = new Room(3, 750, 5000.0);

        // Create Inventory
        Map<String, Integer> availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);

        RoomInventory inventory = new RoomInventory(availability);

        // Search Service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (read-only)
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}
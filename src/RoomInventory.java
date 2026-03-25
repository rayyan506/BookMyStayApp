import java.util.*;

public class RoomInventory {
    private Map<String, Integer> inventory;

    // No-arg constructor (default)
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    // Constructor that accepts a Map
    public RoomInventory(Map<String, Integer> initialInventory) {
        inventory = new HashMap<>(initialInventory); // copy map
    }

    public int getRoomAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getRoomAvailability() {
        return new HashMap<>(inventory);
    }

    public Map<String, Integer> getInventoryMap() {
        return new HashMap<>(inventory);
    }

    public void setRoomCount(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void printInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
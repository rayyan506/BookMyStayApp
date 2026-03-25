/**
 * Use Case 12: Data Persistence & System Recovery
 * Demonstrates restoring system state after an application restart.
 */
public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();
        String filePath = "inventory.txt";

        // Load inventory from file on startup
        persistence.loadInventory(inventory, filePath);

        // Print current inventory
        inventory.printInventory();

        // Example: show availability of a specific room type
        System.out.println("Single rooms available: " + inventory.getRoomAvailability("Single"));

        // Save inventory to persist current state
        persistence.saveInventory(inventory, filePath);
    }
}
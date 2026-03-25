import java.io.*;
import java.util.*;

/**
 * Use Case 12: Data Persistence & System Recovery
 * Responsible for persisting critical system state to a plain text file.
 */
public class FilePersistenceService {

    // Save inventory to a text file
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getInventoryMap().entrySet()) {
                writer.println(entry.getKey() + "-" + entry.getValue());
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from a text file
    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    inventory.setRoomCount(roomType, count);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}
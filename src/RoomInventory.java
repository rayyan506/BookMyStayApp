import java.util.Map;

public class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory(Map<String, Integer> roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}
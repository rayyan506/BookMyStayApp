import java.util.*;

public class AddOnServiceManager {

    /**
     * Maps reservation ID → list of services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /**
     * Constructor
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Add service to a reservation
     */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculate total cost of services
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services =
                servicesByReservation.getOrDefault(reservationId, new ArrayList<>());

        double total = 0;

        for (AddOnService s : services) {
            total += s.getCost();
        }

        return total;
    }
}
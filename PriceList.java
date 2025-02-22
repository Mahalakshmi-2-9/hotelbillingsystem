import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private Map<String, Double> menu;

    public PriceList() {
        menu = new HashMap<>();
        menu.put("Burger", 120.0);
        menu.put("Pizza", 250.0);
        menu.put("Pasta", 180.0);
        menu.put("Fries", 100.0);
        menu.put("Coke", 50.0);
    }

    public void displayMenu() {
        System.out.println("----- MENU -----");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + ": ₹" + item.getValue());
        }
    }

    public Double getPrice(String item) {
        return menu.getOrDefault(item, 0.0);
    }
}

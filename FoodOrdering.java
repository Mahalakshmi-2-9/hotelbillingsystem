import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodOrdering {
    private Map<String, Integer> order;
    private PriceList priceList;

    public FoodOrdering() {
        order = new HashMap<>();
        priceList = new PriceList();
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the Food Ordering System!");
        priceList.displayMenu();

        while (true) {
            System.out.print("Enter food item to order (or type 'done' to finish): ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            if (priceList.getPrice(choice) == 0.0) {
                System.out.println("Invalid item! Please choose from the menu.");
            } else {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                order.put(choice, order.getOrDefault(choice, 0) + quantity);
                System.out.println(choice + " added to order.");
            }
        }
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public PriceList getPriceList() {
        return priceList;
    }
}

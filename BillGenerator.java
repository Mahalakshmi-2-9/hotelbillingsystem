import java.util.Map;

public class BillGenerator {
    private FoodOrdering foodOrdering;

    public BillGenerator(FoodOrdering foodOrdering) {
        this.foodOrdering = foodOrdering;
    }

    public void generateBill() {
        Map<String, Integer> order = foodOrdering.getOrder();
        PriceList priceList = foodOrdering.getPriceList();

        if (order.isEmpty()) {
            System.out.println("No items ordered. Exiting...");
            return;
        }

        System.out.println("\n----- BILL -----");
        double total = 0.0;

        for (Map.Entry<String, Integer> item : order.entrySet()) {
            String itemName = item.getKey();
            int quantity = item.getValue();
            double price = priceList.getPrice(itemName);
            double cost = price * quantity;

            System.out.println(itemName + " x " + quantity + " = ₹" + cost);
            total += cost;
        }

        System.out.println("----------------");
        System.out.println("Total: ₹" + total);
        System.out.println("Thank you! Visit Again.");
    }
}

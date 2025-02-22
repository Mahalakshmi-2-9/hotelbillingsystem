public class Main {
    public static void main(String[] args) {
        FoodOrdering foodOrdering = new FoodOrdering();
        foodOrdering.placeOrder();

        BillGenerator billGenerator = new BillGenerator(foodOrdering);
        billGenerator.generateBill();
    }
}

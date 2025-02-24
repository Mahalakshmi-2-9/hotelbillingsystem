import java.util.Scanner;

public class RestaurantBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item[] vegMenu = PriceList.getVegMenu();
        Item[] nonVegMenu = PriceList.getNonVegMenu();

        Item[] combinedMenu = new Item[vegMenu.length + nonVegMenu.length];
        System.arraycopy(vegMenu, 0, combinedMenu, 0, vegMenu.length);
        System.arraycopy(nonVegMenu, 0, combinedMenu, vegMenu.length, nonVegMenu.length);

        Customer customer = new Customer();
        customer.setDetails();

        char addMore = 0;
        do {
            System.out.println("\nVeg Menu:");
            for (int i = 0; i < vegMenu.length; i++) {
                System.out.println((i + 1) + ". " + vegMenu[i].name + " - ₹" + vegMenu[i].price);
            }

            System.out.println("\nNon-Veg Menu:");
            for (int i = 0; i < nonVegMenu.length; i++) {
                System.out.println((i + 1 + vegMenu.length) + ". " + nonVegMenu[i].name + " - ₹" + nonVegMenu[i].price);
            }

            System.out.print("Select item number: ");
            int choice = scanner.nextInt() - 1;

            if (choice < 0 || choice >= combinedMenu.length) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            combinedMenu[choice].quantity += quantity;

            System.out.print("Add more items? (Y/N): ");
            addMore = scanner.next().charAt(0);

        } while (addMore == 'Y' || addMore == 'y');

        BillGenerator.generateBill(combinedMenu, customer);
        scanner.close();
    }
}

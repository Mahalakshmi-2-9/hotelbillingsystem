// BillGenerator.java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BillGenerator {
    static final float SGST = 2.5F;
    static final float CGST = 2.5F;

    public static void generateBill(Item[] menu, Customer customer) {
        double total = 0;
        System.out.println("\n----------------------------------------------------------------------------------------------------");
        System.out.println("|                                         MAX RESTAURANT                                             |");
        System.out.println("|                     No.40, New Perugalathur Main Road, Chennai-600117                              |");
        System.out.println("|                                   Phone: 1234567890                                                |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Customer Name : " + customer.getName());
        System.out.println("Mobile Number : " + customer.getMobileNumber());

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        Random random = new Random();
        int billNo = random.nextInt(900) + 100;

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        System.out.println("Date         : " + date.format(dateFormat));
        System.out.println("Time         : " + time.format(timeFormat));
        System.out.println("Bill No      : " + billNo);

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-5s | %-10s | %-10s |%n", "Item", "Qty", "Rate", "Total"                                  );
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Item item : menu) {
            if (item.quantity > 0) {
                System.out.printf("| %-25s | %-5d | ₹%-9.2f | ₹%-9.2f |%n", item.name, item.quantity, item.price, item.getTotal());
                total += item.getTotal();
            }
        }

        double sgst = total * SGST / 100;
        double cgst = total * CGST / 100;
        double grandTotal = total + sgst + cgst;

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-5s | %-10s | ₹%-9.2f |%n", "Subtotal", "", "", total);
        System.out.printf("| %-25s | %-5s | %-10s | ₹%-9.2f |%n", "SGST (2.5%)", "", "", sgst);
        System.out.printf("| %-25s | %-5s | %-10s | ₹%-9.2f |%n", "CGST (2.5%)", "", "", cgst);
        System.out.printf("| %-25s | %-5s | %-10s | ₹%-9.2f |%n", "Grand Total", "", "", grandTotal);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("|                                          Thank you! Visit again!                                 |");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
}


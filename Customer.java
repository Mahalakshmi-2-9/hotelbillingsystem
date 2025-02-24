import java.util.Scanner;

public class Customer {
    private String name;
    private String mobileNumber;

    Scanner input = new Scanner(System.in);

    public void setDetails() {
        System.out.print("Enter your name: ");
        this.name = input.nextLine();

        while (true) {
            System.out.print("Enter your phone number: ");
            this.mobileNumber = input.nextLine();
            if (this.mobileNumber.matches("\\d{10}")) break;
            System.out.println("Invalid phone number! Please enter a 10-digit number.");
        }
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}

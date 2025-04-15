import java.util.Scanner;

public class Currency_Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount;
        String from, to;
        double result = 0.0;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Currency Converter ---");
            System.out.print("Enter amount: ");
            amount = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.print("Convert from (INR/USD/EUR/GBP): ");
            from = sc.nextLine().toUpperCase();
            System.out.print("Convert to (INR/USD/EUR/GBP): ");
            to = sc.nextLine().toUpperCase();

            // Example rates
            double inrToUsd = 0.012;
            double inrToEur = 0.011;
            double inrToGbp = 0.0095;
            double usdToInr = 83.0;
            double eurToInr = 89.0;
            double gbpToInr = 105.0;

            if (from.equals("INR")) {
                switch (to) {
                    case "USD":
                        result = amount * inrToUsd;
                        break;
                    case "EUR":
                        result = amount * inrToEur;
                        break;
                    case "GBP":
                        result = amount * inrToGbp;
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        continue;
                }
            } else if (to.equals("INR")) {
                switch (from) {
                    case "USD":
                        result = amount * usdToInr;
                        break;
                    case "EUR":
                        result = amount * eurToInr;
                        break;
                    case "GBP":
                        result = amount * gbpToInr;
                        break;
                    default:
                        System.out.println("Invalid source currency.");
                        continue;
                }
            } else {
                System.out.println("Only INR conversion supported in this version.");
                continue;
            }

            System.out.printf("%.2f %s = %.2f %s\n", amount, from, result, to);

            System.out.print("Do you want to convert again? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("no")) {
                exit = true;
            }
        }

        System.out.println("Thank you for using the converter.");
        sc.close();
    }
}
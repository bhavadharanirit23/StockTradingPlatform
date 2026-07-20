import java.util.Scanner;
class Stock {
    String name = "TCS";
    int price = 1000;
}
public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock s = new Stock();
        int balance = 10000;
        int shares = 0;
        int choice, qty;
        do {
            System.out.println("\n----- Stock Trading Platform -----");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Stock Name : " + s.name);
                    System.out.println("Stock Price: Rs." + s.price);
                    break;

                case 2:
                    System.out.print("Enter number of shares to buy: ");
                    qty = sc.nextInt();
                    if (qty * s.price <= balance) {
                        shares = shares + qty;
                        balance = balance - (qty * s.price);
                        System.out.println("Stock Bought Successfully!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter number of shares to sell: ");
                    qty = sc.nextInt();
                    if (qty <= shares) {
                        shares = shares - qty;
                        balance = balance + (qty * s.price);
                        System.out.println("Stock Sold Successfully!");
                    } else {
                        System.out.println("Not Enough Shares!");
                    }
                    break;

                case 4:
                    System.out.println("\n----- Portfolio -----");
                    System.out.println("Shares Owned : " + shares);
                    System.out.println("Balance      : Rs." + balance);
                    System.out.println("Portfolio Value : Rs." + (shares * s.price));
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
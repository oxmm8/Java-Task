import java.util.Scanner;

public class ATM {
    public static void main(String args[])
{
        int Balance = 100000;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("ATM");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for Exit");
            System.out.print("Choose the option: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter money to withdraw: ");
                    int Withdraw = scan.nextInt();

                    if (Balance >= Withdraw){
                        Balance = Balance - Withdraw;
                        System.out.println("Please collect your money.");
                    } else {
                        System.out.println("Insufficient Balance.");
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter money to deposit: ");
                    int Deposit = scan.nextInt();
                    Balance = Balance + Deposit;
                    System.out.println("Money has been successfully deposited.");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Balance: " + Balance);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting. Thank you for using our ATM.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
    }
}

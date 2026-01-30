import java.util.Scanner;

public class Banking
{

    static Accounts account;
    static Scanner input;
    static int menuI;

    public Banking()
    {
        input = new Scanner(System.in);
    }

    public static void main(String[] args)
    {


        Banking bank = new Banking();
        bank.run();
    } //main function



    public void createAccount()
    {
        System.out.println("Welcome to WIS Banking, Please type in your name:");
        String name = input.nextLine();
        account = new Accounts(name);
    }//create account function

    public void run()
    {


        System.out.println("Welcome to WIS Banking please login below or press 0 if new. \n Account Number:");
        //auth goes here
        menuI = input.nextInt();

        while(!account.auth(menuI)) {
            if (menuI == 0) {
                createAccount();
            } else if (account.auth(menuI)) {


                System.out.println("Welcome " + account.name + "\n 1. Deposit \n 2. Withdraw");
                menuI = input.nextInt();

                while (menuI != 0) {
                    switch (menuI) {
                        case 1:
                            System.out.println("How much do you want to deposit?:");
                            int amount = input.nextInt();
                            input.nextLine();
                            account.deposit(amount);
                            System.out.println("Your new balance is: " + account.bal);
                            menuI = 99;
                            break;
                        case 2:
                            System.out.println("How much do you want to withdraw?:");
                            amount = input.nextInt();
                            input.nextLine();
                            account.withdraw(amount);
                            System.out.println("Your new balance is: " + account.bal);
                            menuI = 99;
                            break;
                        case 3:
                            System.out.println("===========\nTransaction History:");
                            account.transactionHistory();
                            System.out.println("===========");
                        case 4:
                            System.out.println("Account Number is: " + account.checkAccount());
                        default:
                            System.out.println("Welcome " + account.name + "\n 1. Deposit \n 2. Withdraw");
                            menuI = input.nextInt();
                    }
                }
            } else {
                System.out.println("Account Doesnt Match any please try again");
            }
        }
    } //run function







} // Banking Class

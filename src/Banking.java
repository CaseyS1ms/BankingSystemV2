import java.util.Scanner;
import java.util.ArrayList;

public class Banking
{

    static Accounts account;
    static Scanner input;
    static int menuI;
    static ArrayList<Accounts> accountsList;

    public Banking()
    {
        input = new Scanner(System.in);
        accountsList = new ArrayList<>();
    }

    public static void main(String[] args)
    {


        Banking bank = new Banking();
        bank.run();
    } //main function



    public void createAccount()
    {
        System.out.println("Welcome to WIS Banking, Please type in your name:");
        input.nextLine();
        String name = input.nextLine();
        account = new Accounts(name);
        accountsList.add(account);

        System.out.println("Your Details are as follows. \n Account Number: " + account.account_No);
    }//create account function

    public void run()
    {

        if(account == null)
        {
            createAccount();
        }

        System.out.println("Welcome to WIS Banking please login below or press 0 if new. \n Account Number:");
        menuI = input.nextInt();

        if (account.auth(menuI)) {


            System.out.println("Welcome " + account.name + "\n 1. Deposit \n 2. Withdraw");
            menuI = input.nextInt();

            mainMenu();

        } else if (menuI == 0) {
            createAccount();
        } else
        {
            System.out.println("Account Doesnt Match any please try again");
        }

        mainMenu();

    } //run function


    public void mainMenu()
    {
        System.out.println("Welcome " + account.name + "\n 1. Deposit \n 2. Withdraw");
        menuI = input.nextInt();
        int amount;

        while (menuI != 0) {
            switch (menuI) {
                case 1:
                    System.out.println("How much do you want to deposit?:");
                    amount = input.nextInt();
                    input.nextLine();
                    account.deposit(amount);
                    System.out.println("Your new balance is: " + account.bal);
                    break;
                case 2:
                    System.out.println("How much do you want to withdraw?:");
                    amount = input.nextInt();
                    input.nextLine();
                    account.withdraw(amount);
                    System.out.println("Your new balance is: " + account.bal);
                    break;
                case 3:
                    System.out.println("===========\nTransaction History:");
                    account.transactionHistory();
                    System.out.println("===========");
                    break;
                case 4:
                    System.out.println("Account Number is: " + account.checkAccount());
                    break;
                case 5:
                    listAccounts();
                    break;
                case 6:
                    createAccount();
                    break;
                default:
                    System.out.println("Error");
                    break;

            }
            System.out.println("Welcome " + account.name + "\n 1. Deposit \n 2. Withdraw");
            menuI = input.nextInt();
        }
    } // Main menu function


    public void listAccounts()
    {
        for(Accounts t: accountsList)
        {
            System.out.println("Account Number: " + t.account_No + " Name: " + t.name);
        }
    } //list accounts function







} // Banking Class

import java.util.Scanner;
import java.util.ArrayList;

public class Banking
{

    static Accounts account;
    static Scanner input;
    static int menuI;

    static ArrayList<Accounts> accountsList = new ArrayList<>();

    public Banking()
    {


        input = new Scanner(System.in);


    }

    public static void main(String[] args)
    {
        String inname = "JohnClyde";
        account = new Accounts(inname);
        accountsList.add(account);

        Banking bank = new Banking();
        bank.run();


    } //main function



    public void createAccount()
    {
        System.out.println("Welcome to WIS Banking, Please type in your name:");
        String name = input.nextLine();
        account = new Accounts(name);
        accountsList.add(account);

        System.out.println("Your Details are as follows. \nAccount Number: " + account.account_No);
    }//create account function

    public void run()
    {


        if(login() == true)
        {
            mainMenu();
        }
        else
        {
            System.out.println("No Account found please make one below");
            createAccount();
            mainMenu();
        }

    } //run function


    public void mainMenu()
    {
        int amount = 0;
        int toaccount; //account number to send to
        System.out.println("Welcome: " + account.name);
        System.out.println("==========\n 1.Deposit\n 2.Withdraw\n 3.Send Money\n 4.Check Balance\n 5.Check Details\n 6.Logout\n==========");
        menuI = input.nextInt();

        while(menuI != 7)
        {
            switch (menuI) {
                case 1:
                    //amount input
                    account.deposit(amount);
                    break;
                case 2:
                    //amount input
                    account.withdraw(amount);
                    break;
                case 3:
                    //amount input
                    //account number to send to
                    //sendmoney();
                    break;
                case 4:
                    account.checkBalance();
                    break;
                case 5:
                    System.out.println(account.checkAccount());
                    break;
                case 6:
                    logout();
                    break;
                case 99:
                    createAccount();
                    break;
                case 98:
                    listAccounts();
                    break;
            }
            System.out.println("Welcome: " + account.name);
            System.out.println("==========\n 1.Deposit\n 2.Withdraw\n 3.Send Money\n 4.Check Balance\n 5.Check Details\n 6.Logout\n==========");
            menuI = input.nextInt();
        }
    } // Main menu function

    public Boolean login()
    {
        //checking if there is any accounts
        System.out.println("Welcome please enter Account Number: ");
        int inputNumber = input.nextInt();
        input.nextLine();

        for(Accounts acc: accountsList)
        {
            if(acc.account_No == inputNumber)
            {
                account = acc;
                return true;
            }
        }
        return false;
    } //login function


    public void logout()
    {
        run();
    } //logout function


    public void listAccounts()
    {
        for(Accounts t: accountsList)
        {
            System.out.println("Account Number: " + t.account_No + " Name: " + t.name);
        }
    } //list accounts function







} // Banking Class

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;

public class Banking
{

    Accounts account;
    Scanner input;
    Random rand;
    ArrayList<Accounts> accountsList = new ArrayList<>();

    int menuI;




    public Banking()
    {


        input = new Scanner(System.in);


    }

    public static void main(String[] args)
    {
//        String inname = "JohnClyde";
//        account = new Accounts(87692,inname,0);
//        accountsList.add(account);
//        updateAccountsList();
        Banking bank = new Banking();



        bank.run();


    } //main function



    public void createAccount()
    {
        rand = new Random();
        System.out.println("Welcome to WIS Banking, Please type in your name:");
        String name = input.nextLine();
        int accountN = rand.nextInt(90000) + 1000;
        account = new Accounts(accountN,name,0);
        accountsList.add(account);
        updateAccountsList();

        System.out.println("Your Details are as follows. \nAccount Number: " + account.getAccount_No());
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
        System.out.println("Welcome: " + account.getName());
        System.out.println("==========\n 1.Deposit\n 2.Withdraw\n 3.Send Money\n 4.Check Balance\n 5.Check Details\n 6.Logout\n==========");
        menuI = input.nextInt();
        input.nextLine();

        while(menuI != 7)
        {
            switch (menuI) {
                case 1:
                    System.out.println("How much do you want to deposit:");
                    amount = input.nextInt();
                    input.nextLine();
                    account.deposit(amount);

                    break;
                case 2:
                    System.out.println("How much do you want to withdraw:");
                    amount = input.nextInt();
                    input.nextLine();
                    account.withdraw(amount);
                    break;
                case 3:
                    System.out.println("What account do you want to send to:");
                    toaccount = input.nextInt();
                    input.nextLine();
                    System.out.println("How much do you want to send:");
                    amount = input.nextInt();
                    input.nextLine();
                    sendmoney(amount,toaccount);
                    break;
                case 4:
                    System.out.println("£" + account.checkBalance());
                    break;
                case 5:
                    System.out.println(account.checkAccount());
                    account.transactionHistory();
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
            System.out.println("Welcome: " + account.getName());
            System.out.println("==========\n 1.Deposit\n 2.Withdraw\n 3.Send Money\n 4.Check Balance\n 5.Check Details\n 6.Logout\n==========");
            menuI = input.nextInt();
            input.nextLine();
        }
    } // Main menu function

    public Boolean login()
    {
        //checking if there is any accounts
        loadAccounts();
        if(account == null)
        {
            createAccount();
        }
        System.out.println("Welcome please enter Account Number: ");
        int inputNumber = input.nextInt();
        input.nextLine();

        for(Accounts acc: accountsList)
        {
            if(acc.getAccount_No() == inputNumber)
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
            System.out.println("Account Number: " + t.getAccount_No() + " Name: " + t.getName());
        }
    } //list accounts function


    public void sendmoney(int amount, int accountnumber)
    {
        Accounts recipient = null;

        for(Accounts acc: accountsList)
        {
            if(acc.getAccount_No() == accountnumber)
            {
                recipient = acc;
                break;
            }
        }

        if (recipient != null)
        {
            if(account.withdraw(amount) == 1)
            {
                System.out.println("Not enough funds to transfer.");
            }
            else
            {
                recipient.deposit(amount);
                System.out.println("Transaction Succesfull");
            }


        }
        else
        {
            System.out.println("Failure");
        }

    } //send money function


    public void updateAccountsList()
    {
        try(FileWriter writer = new FileWriter("AccountsList.txt"))
        {
            for(Accounts acc : accountsList)
            {
                writer.write(acc.getAccount_No() + "," + acc.getName() + "," + acc.getBal() + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("An Error has occurred");
        }
    }// update accounts list function


    public void loadAccounts()
    {

        File accL = new File("AccountsList.txt");

        try(Scanner read = new Scanner(accL))
        {
            while(read.hasNextLine())
            {
                String data = read.nextLine();
                String regex = "[,]";
                String[] myArray = data.split(regex);
                account = new Accounts(Integer.parseInt(myArray[0]), myArray[1],Integer.parseInt(myArray[2]));
                accountsList.add(account);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }

    }







} // Banking Class

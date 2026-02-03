import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;

public class Banking
{

    private Accounts account;
    private Scanner input;
    private Random rand;
    private ArrayList<Accounts> accountsList = new ArrayList<>();


    public Banking()
    {


        input = new Scanner(System.in);


    }

    public static void main(String[] args)
    {
        Banking bank = new Banking();
    } //main function

    //GETTERS


    public Accounts getAccount() {
        return account;
    } // Accounts Getter

    public ArrayList<Accounts> getAccountsList() {
        return accountsList;
    } // Accounts List Getter

    public int createAccount(String name, String pin)
    {
        rand = new Random();
        int accountN = rand.nextInt(90000) + 1000;
        account = new Accounts(accountN,name,0,pin);
        accountsList.add(account);
        updateAccountsList();

        return accountN;
    }//create account function

    public Boolean login(int inputNumber, String pinN)
    {
        //checking if there is any accounts
        loadAccounts();
        //check account did go here

        //enter account number

        for(Accounts acc: accountsList)
        {
            if(acc.getAccount_No() == inputNumber)
            {
                //enter pin number

                if(acc.getPin().equals(pinN))
                {
                    account = acc;
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    } //login function


    public void logout()
    {
        account = null;
    } //logout function





    public String sendmoney(int amount, int accountnumber)
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
                return "Failure: Not enough Funds";
            }
            else
            {
                recipient.deposit(amount);
                updateAccountsList();
                return "Transaction Successful";
            }


        }
        else
        {
            return "Failure: Couldn't Find Account";
        }

    } //send money function


    public String updateAccountsList()
    {
        try(FileWriter writer = new FileWriter("AccountsList.txt"))
        {
            for(Accounts acc : accountsList)
            {
                writer.write(acc.getAccount_No() + "," + acc.getName() + "," + acc.getBal() + "," + acc.getPin() + "\n");
            }
        }
        catch (IOException e)
        {
            return "An Error has Occured";
        }
        return "Success";
    }// update accounts list function


    public String loadAccounts()
    {

        File accL = new File("AccountsList.txt");

        try(Scanner read = new Scanner(accL))
        {
            while(read.hasNextLine())
            {
                String data = read.nextLine();
                String regex = "[,]";
                String[] myArray = data.split(regex);
                account = new Accounts(Integer.parseInt(myArray[0]), myArray[1],Integer.parseInt(myArray[2]), myArray[3]);
                accountsList.add(account);
            }
        }
        catch (FileNotFoundException e)
        {
            return "File Not Found";
        }
        return "Success";
    }
} // Banking Class

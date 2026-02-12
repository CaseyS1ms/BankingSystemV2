import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;

public class Banking
{

    private Account account;

    private ArrayList<Account> accountsList = new ArrayList<>();

    public Banking()
    {
        loadAccounts();
    }

    public static void main(String[] args)
    {
        Banking bank = new Banking();
    } //main function

    //GETTERS


    public Account getAccount() {
        return account;
    } // Account Getter

    public ArrayList<Account> getAccountsList() {
        return accountsList;
    } // Account List Getter

    public int createAccount(String name, String pin)
    {
        Random rand = new Random();
        int accountN = rand.nextInt(90000) + 1000;
        account = new Account(accountN,name,0,pin);
        accountsList.add(account);
        updateAccountsList();

        return accountN;
    }//create account function

    public Boolean login(int inputNumber, String pinN)
    {
        //checking if there is any accounts

        //check account did go here

        //enter account number

        for(Account acc: accountsList)
        {
            if(acc.getAccountNumber() == inputNumber)
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
        Account recipient = null;

        for(Account acc: accountsList)
        {
            if(acc.getAccountNumber() == accountnumber)
            {
                recipient = acc;
                break;
            }
        }

        if (recipient != null)
        {
            if(!account.withdraw(amount))
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

    public void deposit(int amount)
    {
        account.deposit(amount);
        updateAccountsList();
    }


    public String updateAccountsList()
    {
        try(FileWriter writer = new FileWriter("AccountsList.txt"))
        {
            for(Account acc : accountsList)
            {
                writer.write(acc.getAccountNumber() + "," + acc.getName() + "," + acc.getBalance() + "," + acc.getPin() + "\n");
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
                account = new Account(Integer.parseInt(myArray[0]), myArray[1],Integer.parseInt(myArray[2]), myArray[3]);
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

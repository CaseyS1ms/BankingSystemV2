import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Account
{


    private int accountNumber;
    private String name;
    private int balance;
    private String pin;
    private ArrayList<String> transactionH;

    public Account(int accountNumber, String name, int balance, String pin)
    {
        transactionH = new ArrayList<String>();
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;


    } //constructor

    //GETTERS
    public int getBalance()
    {
        return balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getPin()
    {
        return pin;
    }





    public int deposit(int amount)
    {
    this.balance += amount;
    transactionH.add("Deposit: " + amount);
    updateTransactionHistory(amount, "Deposit");
    return this.balance;

    } //deposit function

    public boolean withdraw(int amount)
    {
        if(amount > this.balance)
        {
            transactionH.add("Attempted Withdrawal");
            return false;

        }else
        {
            this.balance -= amount;
            transactionH.add("Withdraw: " + amount);
            updateTransactionHistory(amount, "Withdraw");
            return true;
        }

    }//withdraw function

    public void transactionHistory()
    {
        for(String t: transactionH)
        {
            System.out.println(t);
        }


    }//transaction history

    public Integer checkBalance()
    {
        return this.balance;
    }//check Balance function

    public int checkAccount()
    {
        return this.accountNumber;
    }//check account function

    public Boolean auth(int accountIn)
    {
        return accountIn == this.accountNumber;
    }//auth function



    public void accountDetails()
    {
        System.out.println("name: " + this.name + "\naccount number: " + this.accountNumber);
    }


    public void updateTransactionHistory(int amount,String type)
    {
        try ( FileWriter writer = new FileWriter("//Users//caseysims//IdeaProjects//BankingSystemV2//transactionHistory//" + this.accountNumber + "History.txt",true))
        {
            if("Withdraw".equals(type))
            {
                writer.append("Withdraw: " + amount + "\n");
            }
            else if("Deposit".equals(type))
            {
                writer.append("Deposit: " + amount + "\n");
            }


        }
        catch (IOException e)
        {
            System.out.println("An Error has Occurred");
        }
    }



}//end of class

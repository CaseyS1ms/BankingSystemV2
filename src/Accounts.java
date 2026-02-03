import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Accounts
{


    private int account_No;
    private String name;
    private int bal;
    private String pin;
    private ArrayList<String> transactionH;
    Random rand;

    public Accounts(int account_No, String name, int bal, String pin)
    {
        transactionH = new ArrayList<String>();
        rand = new Random();
        this.bal = bal;
        this.name = name;
        this.account_No = account_No;
        this.pin = pin;


    } //constructor

    //GETTERS
    public int getBal()
    {
        return bal;
    }

    public int getAccount_No()
    {
        return account_No;
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
    this.bal += amount;
    transactionH.add("Deposit: " + amount);
    updateTransactionHistory(amount, "Deposit");
    return this.bal;

    } //deposit function

    public int withdraw(int amount)
    {
        if(amount > this.bal)
        {
            transactionH.add("Attempted Withdrawal");
            return 1;

        }else
        {
            this.bal -= amount;
            transactionH.add("Withdraw: " + amount);
            updateTransactionHistory(amount, "Withdraw");

        }
        return this.bal;
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
        return this.bal;
    }//check Balance function

    public int checkAccount()
    {
        return this.account_No;
    }//check account function

    public Boolean auth(int accountIn)
    {
        return accountIn == this.account_No;
    }//auth function



    public void accountDetails()
    {
        System.out.println("name: " + this.name + "\naccount number: " + this.account_No);
    }


    public void updateTransactionHistory(int amount,String type)
    {
        try ( FileWriter writer = new FileWriter("//Users//caseysims//IdeaProjects//BankingSystemV2//transactionHistory//" + this.account_No + "History.txt",true))
        {
            if(type == "Withdraw")
            {
                writer.append("Withdraw: " + amount + "\n");
            }
            else if(type == "Deposit")
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

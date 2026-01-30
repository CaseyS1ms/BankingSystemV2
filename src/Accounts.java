import java.util.ArrayList;
import java.util.Random;

public class Accounts
{


    int account_No;
    String name;
    int bal;

    static ArrayList<String> transactionH;
    static Random rand;



    public Accounts(String inname)
    {
        transactionH = new ArrayList<String>();
        rand = new Random();

        bal = 0;
        name = inname;
        account_No = rand.nextInt(90000) + 10000;
    }


    public int deposit(int amount)
    {
    this.bal += amount;
    transactionH.add("Deposit: " + amount);
    return this.bal;

    } //deposit function

    public int withdraw(int amount)
    {
        if(amount > this.bal)
        {
            System.out.println("Withdraw failed: insufficient funds");
            transactionH.add("Attempted Withdrawal");
        }else
        {
            this.bal -= amount;
            transactionH.add("Withdraw: " + amount);

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

    public void switchAccount()
    {

    }//switch account function

    public void accountDetails()
    {
        System.out.println("name: " + this.name + "\naccount number: " + this.account_No);
    }



}//end of class

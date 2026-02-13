import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class MainScreen
{

    private String name;
    private int balance;
    private int loggedAccountNumber;



    public MainScreen(String name, int balance, int loggedAccountNumber)
    {
        this.name = name;
        this.balance = balance;
        this.loggedAccountNumber = loggedAccountNumber;
    }


//    private Label accountNumber;

    private Button logout;
    private Button withdraw;
    private Button deposit;
    private Button sendMoney;
    private Button transactionHistory;

    //GETTERS
    public Button getLogout(){return logout;}

    public Button getWithdraw(){return withdraw;}

    public Button getDeposit() {return deposit;}

    public Button getSendMoney() {return sendMoney;}

    public Button getTransactionHistory() {return transactionHistory;}

    public VBox createMainMenu()
    {
        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("WIS Banking");
        Label info1Label = new Label("Balance: £" + balance);
        Label info2Label = new Label("Account Number: " + loggedAccountNumber);
        Label info3Label = new Label("Name: " + name);
        logout = new Button("Logout");
        withdraw = new Button("Withdraw");
        deposit = new Button("Deposit");
        sendMoney = new Button("Send Money");
        transactionHistory = new Button("Transaction History");





        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(info3Label);
        layout.getChildren().add(info2Label);
        layout.getChildren().add(info1Label);
        layout.getChildren().add(deposit);
        layout.getChildren().add(withdraw);
        layout.getChildren().add(sendMoney);
        layout.getChildren().add(transactionHistory);
        layout.getChildren().add(logout);



        return layout;
    }






}

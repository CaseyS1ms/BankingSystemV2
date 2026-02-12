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


    private Label accountNumber;
    private Button logout;
    private Button withdraw;
    private Button deposit;
    private Button sendMoney;

    //GETTERS
    public Button getLogout(){return logout;}

    public Button getWithdraw(){return withdraw;}

    public Button getDeposit() {return deposit;}

    public Button getSendMoney() {return sendMoney;}

    public VBox createMainMenu()
    {
        VBox layout = new VBox();
        Label welcomeLabel = new Label("WIS Banking");
        Label info1Label = new Label("Balance: £" + balance);
        Label info2Label = new Label("Account Number: " + loggedAccountNumber);
        Label info3Label = new Label("Name: " + name);
        logout = new Button("Logout");
        withdraw = new Button("Withdraw");
        deposit = new Button("Deposit");
        sendMoney = new Button("Send Money");





        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(info3Label);
        layout.getChildren().add(info2Label);
        layout.getChildren().add(info1Label);
        layout.getChildren().add(deposit);
        layout.getChildren().add(withdraw);
        layout.getChildren().add(sendMoney);
        layout.getChildren().add(logout);



        return layout;
    }






}

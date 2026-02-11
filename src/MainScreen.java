import javafx.scene.control.*;
import javafx.scene.layout.*;


public class MainScreen
{
    private Label accountNumber;
    private Button logout;
    private Button withdraw;
    private Button deposit;
    private Button sendMoney;

    //GETTERS
    public Button getLogout(){return logout;}






    public VBox createMainMenu()
    {
        VBox layout = new VBox();
        Label welcomeLabel = new Label("Welcome to WIS Banking");
        logout = new Button("Logout");
        withdraw = new Button("Withdraw");
        deposit = new Button("Deposit");
        sendMoney = new Button("Send Money");





        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(deposit);
        layout.getChildren().add(withdraw);
        layout.getChildren().add(sendMoney);
        layout.getChildren().add(logout);



        return layout;
    }






}

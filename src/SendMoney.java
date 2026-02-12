import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SendMoney
{
    private Button sendMoney;
    private Button backButton;

    private TextField accountTo;
    private TextField amount;

    public Button getBackButton() {return backButton;}

    public Button getSendMoney() {return sendMoney;}

    int getAmount()
    {
        return Integer.parseInt(amount.getText());
    }

    public int getAccountNumber() {
        return Integer.parseInt(accountTo.getText());
    }

    public VBox createSendMoneyMenu()
    {
        VBox layout = new VBox();

        sendMoney= new Button("Send");
        backButton = new Button("Back");

        amount = new TextField("0");
        accountTo = new TextField("Account Number");


        layout.getChildren().add(amount);
        layout.getChildren().add(accountTo);
        layout.getChildren().add(sendMoney);
        layout.getChildren().add(backButton);


        return layout;
    } //end of ui


}//end of send money class

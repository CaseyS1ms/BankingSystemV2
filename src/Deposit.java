import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Deposit
{
    private Button depositButton;
    private Button backButton;

    private TextField amount;

    public Button getDepositButton(){return depositButton;}
    public Button getBackButton(){return backButton;}

    int getAmount()
    {
        int amountSpecified = Integer.parseInt(amount.getText());
        return amountSpecified;
    }


    public VBox createDepositMenu()
    {
        VBox layout = new VBox();

        depositButton = new Button("Deposit");
        backButton = new Button("Back");

        amount = new TextField("0");


        layout.getChildren().add(amount);
        layout.getChildren().add(depositButton);
        layout.getChildren().add(backButton);


        return layout;
    } //end of ui


}// end of deposit class

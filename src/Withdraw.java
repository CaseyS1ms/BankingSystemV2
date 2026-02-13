import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Withdraw
{
    private Button withdrawButton;
    private Button backButton;

    private TextField amount;

    public Button getWithdrawButton(){return withdrawButton;}
    public Button getBackButton(){return backButton;}

    int getAmount()
    {
        int amountSpecified = Integer.parseInt(amount.getText());
        return amountSpecified;
    }


    public VBox createWithdrawMenu()
    {
        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        withdrawButton = new Button("Withdraw");
        backButton = new Button("Back");

        amount = new TextField("0");


        layout.getChildren().add(amount);
        layout.getChildren().add(withdrawButton);
        layout.getChildren().add(backButton);


        return layout;
    } //end of ui


}// end of deposit class
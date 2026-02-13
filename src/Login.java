import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Login
{
    private TextField accountNumber;
    private PasswordField pinNumber;
    private Button loginButton;
    private Button createAccount;
    private Label errorLabel;

    private int width;
    private int height;



    public Login()
    {
        width = 720;
        height = 1000;

    } //end of constructor



    //GETTERS

    public int accountNumberIn()
    {
        int acc_N = Integer.parseInt(accountNumber.getText());


        return acc_N;
    }

//    public String pinNumber()
//    {
//        String pinNumberIn = pinNumber.getText();
//
//        return pinNumberIn;
//    }

    public Button getLoginButton() {return loginButton;}

    public Button getCreateAccountButton(){return createAccount;}

    //METHODS

    public VBox createLoginPage()
    {
        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("Welcome To WIS Banking");
        Label accountLabel = new Label("Account Number: ");
        Label PinLabel = new Label("Pin Number: ");
        Label Success = new Label("Success!");
        errorLabel = new Label();
        loginButton = new Button("LOGIN");
        pinNumber = new PasswordField();
        accountNumber = new TextField();
        createAccount = new Button("Create Account");


        layout.getChildren().add(welcomeLabel);
        layout.getChildren().add(accountLabel);
        layout.getChildren().add(accountNumber);
        layout.getChildren().add(PinLabel);
        layout.getChildren().add(pinNumber);
        layout.getChildren().add(errorLabel);
        layout.getChildren().add(loginButton);
        layout.getChildren().add(createAccount);








        return layout;
    }//create login page function


    public void showError()
    {
        if(errorLabel == null)
        {
            errorLabel = new Label();

        }
        errorLabel.setText("ERROR");
    }

    public void clearError()
    {
        if(errorLabel != null)
        {
            errorLabel.setText("");
        }
    }






} //End of Login Class

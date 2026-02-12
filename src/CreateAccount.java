import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CreateAccount
{

    private Button createButton;
    private Button backButton;
    private TextField name;
    private PasswordField pin;

    public Button getCreateButton(){return createButton;}

    public Button getBackButton(){return backButton;}


    String getName()
    {
        String namein = name.getText();
        return namein;
    }

    String getPin()
    {
        String pinIN = pin.getText();
        return pinIN;
    }

    public VBox createC_Menu()
    {
        VBox layout = new VBox();
        Label welcome = new Label("Welcome to WIS Banking");
        createButton = new Button("Create Account");
        backButton = new Button("Back");
        name = new TextField();
        pin = new PasswordField();
        Label nameField = new Label("Name: ");
        Label pinField = new Label("Pin: ");


        layout.getChildren().add(nameField);
        layout.getChildren().add(name);
        layout.getChildren().add(pinField);
        layout.getChildren().add(pin);
        layout.getChildren().add(createButton);

        layout.getChildren().add(backButton);


        return layout;
    }








}//end of create account class

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application
{

    private Login login;
    private Banking banking;
    private MainScreen mainScreen;
    private Stage primaryStage;

    public Gui()
    {

    }

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;



        //UI GOES HERE

        banking = new Banking();

        showLoginScreen();



        primaryStage.setTitle("WIS BANKING");
        primaryStage.show();
    }


    public static void main(String[] args)
    {

        launch(args);
    }



    void showLoginScreen()
    {

        Login login = new Login();
        VBox layout = login.createLoginPage();


       login.getLoginButton().setOnAction(e ->
       {
           login.clearError();

           boolean auth = banking.login(login.accountNumberIn(),login.pinNumber());

           if(auth)
           {
               System.out.println("SUCCESS");
               showMainScreen();
           }
           else
           {
               System.out.println("FAIL");
               login.showError();
           }
       });

       Scene loginScene = new Scene(layout, 400, 500);
       primaryStage.setScene(loginScene);
    } // end of login function


    void showMainScreen()
    {
        mainScreen = new MainScreen();

        VBox mainLayout = mainScreen.createMainMenu();


        mainScreen.getLogout().setOnAction(e ->
        {
            showLoginScreen();
        });

        Scene mainScene = new Scene(mainLayout, 400, 500);
        primaryStage.setScene(mainScene);

    } //end of showMainScreen function





}//end of gui class






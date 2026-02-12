import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application
{



    private Login login;
    private Banking banking;
    private MainScreen mainScreen;
    private CreateAccount createAccountScreen;
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

        login.getCreateAccountButton().setOnAction(e ->
        {
            showCreateAccountScreen();
        });



       Scene loginScene = new Scene(layout, 400, 500);
       primaryStage.setScene(loginScene);
    } // end of login function


    void showMainScreen()
    {
        mainScreen = new MainScreen(banking.getAccount().getName(),banking.getAccount().getBalance(),banking.getAccount().getAccountNumber());

        VBox mainLayout = mainScreen.createMainMenu();


        mainScreen.getLogout().setOnAction(e ->
        {
            showLoginScreen();
        });

        mainScreen.getDeposit().setOnAction(e ->
        {
            showDepositScreen();
            System.out.println("DEPOSIT");
        });

        mainScreen.getWithdraw().setOnAction(e ->
        {
            //show withdraw screen
            showWithdrawScreen();
            System.out.println("WITHDRAW");
        });

        mainScreen.getSendMoney().setOnAction(e ->
        {
            //show send money screen
            System.out.println("SEND MONEY");
        });

        Scene mainScene = new Scene(mainLayout, 400, 500);
        primaryStage.setScene(mainScene);

    } //end of showMainScreen function


    void showCreateAccountScreen()
    {

        CreateAccount createAccountScreen = new CreateAccount();
        VBox createAccountLayout = createAccountScreen.createC_Menu();



        createAccountScreen.getBackButton().setOnAction(e ->
        {
            showLoginScreen();
        });

        createAccountScreen.getCreateButton().setOnAction(e ->
        {
            banking.createAccount(createAccountScreen.getName(), createAccountScreen.getPin());

        });

        Scene mainScene = new Scene(createAccountLayout, 400, 500);
        primaryStage.setScene(mainScene);

    }


    void showDepositScreen()
    {
        Deposit deposit = new Deposit();
        VBox showDepositScreen = deposit.createDepositMenu();

        deposit.getBackButton().setOnAction(e ->
        {
            showMainScreen();
        });

        deposit.getDepositButton().setOnAction(e ->
        {
            banking.deposit(deposit.getAmount());
        });

        Scene depositScene = new Scene(showDepositScreen, 500, 400);
        primaryStage.setScene(depositScene);
    }//end of deposit function

    void showWithdrawScreen()
    {
        Withdraw withdraw = new Withdraw();
        VBox showWithdrawScreen = withdraw.createWithdrawMenu();

        withdraw.getBackButton().setOnAction(e ->
        {
            showMainScreen();
        });

        withdraw.getWithdrawButton().setOnAction(e ->
        {
            banking.withdraw(withdraw.getAmount());
        });

        Scene withdrawScene = new Scene(showWithdrawScreen, 500, 400);
        primaryStage.setScene(withdrawScene);
    }


}//end of gui class






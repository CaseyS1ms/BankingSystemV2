import com.sun.javafx.geometry.BoundsUtils;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class TransactionHistory
{


    private ListView transactionList;
    private ArrayList<String> transactionHistory;

    private Button backButton;

    public TransactionHistory(ArrayList<String> transactionHistory)
    {
        transactionList = new ListView();
        this.transactionHistory = transactionHistory;
        System.out.println(transactionHistory.size());
    }//CONSTRUCTOR



    //GETTERS
    public Button getBackButton()
    {
        return backButton;
    }


    public VBox createTransactionListScreen()
    {
        VBox layout = new VBox();
        backButton = new Button("Back");




        layout.getChildren().add(transactionList);
        createHistory(transactionHistory);
        layout.getChildren().add(backButton);



        return layout;
    } // end of ui


    public void createHistory(ArrayList transactionH)
    {
        transactionList.getItems().addAll(transactionH);
    }




}

/**
 * Created by Сергей on 30.03.2019.
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class MoveInWindow
{
    public void display(Stage primaryStage, Human person)
    {
        Stage moveInStage = new Stage();
        moveInStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 200,150);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        moveInStage.initModality(Modality.WINDOW_MODAL);
        moveInStage.initOwner(primaryStage);
        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100/2.0);
            gridpane.getColumnConstraints().add(column);
        }
        Label label = new Label("fsa");
        gridpane.add(label,0,0);
        label = new Label("ffdjk");


    }
}

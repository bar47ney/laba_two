package Maybe;

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

import java.util.ArrayList;

/**
 * Created by Сергей on 09.04.2019.
 */
public class ChangeInfo
{
    private int counter;
    public void display(Stage primaryStage, ArrayList<Student> sl)
    {

        Stage getInfoStage = new Stage();
        getInfoStage.setResizable(false);
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,400,400);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        getInfoStage.initModality(Modality.WINDOW_MODAL);
        getInfoStage.initOwner(primaryStage);

        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100/2.0);
            gridpane.getColumnConstraints().add(column);
        }

        Label label = new Label("Номер сохраняемого или изменяемого элемента");
        gridpane.add(label, 0, 0);

        TextField numberOfElementListField = new TextField();
        numberOfElementListField.setPrefSize(40,40);
        gridpane.add(numberOfElementListField, 0, 1);

        Button saveElement = new Button("Считать");
        saveElement.setPrefSize(80,30);
        gridpane.add(saveElement,0,2);

        Button changeElement = new Button("Поменять");
        changeElement.setPrefSize(80,30);
        gridpane.add(changeElement,1,2);

        root.setCenter(gridpane);
        getInfoStage.setScene(scene);
        getInfoStage.show();

    }

}

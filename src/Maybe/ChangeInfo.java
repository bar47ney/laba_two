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
import java.util.Iterator;

/**
 * Created by Сергей on 09.04.2019.
 */
public class ChangeInfo
{
    private int counter;
    private int i=0;
    public void display(Stage primaryStage, ArrayList<Student> sl, Student student, ArrayList<Worker> wl, Worker worker)
    {
        Stage getInfoStage = new Stage();
        getInfoStage.setResizable(false);
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,400,300);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        getInfoStage.initModality(Modality.WINDOW_MODAL);
        getInfoStage.initOwner(primaryStage);

        Label label = new Label("Номер сохраняемого или изменяемого элемента");
        gridpane.add(label, 0, 0);

        TextField numberOfElementListField = new TextField();
        numberOfElementListField.setPrefSize(20,30);
        gridpane.add(numberOfElementListField, 0, 2);

        Button changeElementWorker = new Button("Поменять рабочего");
        changeElementWorker.setPrefSize(200,30);
        gridpane.add(changeElementWorker,0,1);

        Button changeElementStudent = new Button("Поменять студента");
        changeElementStudent.setPrefSize(200,30);
        gridpane.add(changeElementStudent,0,3);



        changeElementStudent.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                counter = Integer.parseInt(numberOfElementListField.getText());
                Iterator<Student> iter = sl.iterator();
                Student change_student = new Student();
                change_student.moveIn();
                while(i != counter)
                {
                    change_student = iter.next();
                    i++;
                }
                i = 0;
                iter = sl.iterator();
                while(i != counter)
                {
                    change_student.address = iter.next().getAddress();
                    i++;
                }
                change_student.copy(student);
                if(student.address != null)
                {
                    change_student.moveIn();
                    change_student.address.copy(student.address);
                }
                else
                {
                    change_student.address = null;
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Поменял!");
                alert.showAndWait();
                getInfoStage.close();
            }
        });

        changeElementWorker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                counter = Integer.parseInt(numberOfElementListField.getText());
                Iterator<Worker> iter = wl.iterator();
                Worker change_worker = new Worker();
                change_worker.moveIn();
                while(i != counter)
                {
                    change_worker = iter.next();
                    i++;
                }
                i = 0;
                iter = wl.iterator();
                while(i != counter)
                {
                    change_worker.address = iter.next().getAddress();
                    i++;
                }
                change_worker.copy(worker);
                if(worker.address != null)
                {
                    change_worker.moveIn();
                    change_worker.address.copy(worker.address);
                }
                else
                {
                    change_worker.address = null;
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Поменял!");
                alert.showAndWait();
                getInfoStage.close();
            }
        });

        root.setCenter(gridpane);
        getInfoStage.setScene(scene);
        getInfoStage.show();
    }

}

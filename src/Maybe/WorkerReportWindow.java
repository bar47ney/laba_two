package Maybe; /**
 * Created by Сергей on 01.04.2019.
 */


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WorkerReportWindow
{
    public void display(Stage primaryStage, Worker worker)
    {
        Stage getInfoStage = new Stage();
        getInfoStage.setResizable(false);

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,200,150);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        getInfoStage.initModality(Modality.WINDOW_MODAL);
        getInfoStage.initOwner(primaryStage);

        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100/2.0);
            gridPane.getColumnConstraints().add(column);
        }

        Label label = new Label(worker.work());
        gridPane.add(label,0,0);

        if(worker.getBoolStatus() == false)
        {
            label = new Label(worker.work_no());
        }
        else
        {
            label = new Label(worker.work_yes());
        }

        gridPane.add(label,1,0);

        label = new Label("Имя:");
        gridPane.add(label,0,1);

        Label workerFirstNameLabel = new Label(worker.getFirstName());
        gridPane.add(workerFirstNameLabel,1,1);

        label = new Label("Фамилия:");
        gridPane.add(label,0,2);

        Label workerLastNameLabel = new Label(worker.getLastName());
        gridPane.add(workerLastNameLabel,1,2);

        if(worker.address!=null)
        {
            label = new Label("Улица");
            gridPane.add(label,0,3);

            Label streetLabel = new Label(worker.address.getStreet());
            gridPane.add(streetLabel,1,3);

            label = new Label("Дом");
            gridPane.add(label,0,4);

            Label houseLabel = new Label(worker.address.getHouse());
            gridPane.add(houseLabel,1,4);

            label = new Label("Квартира");
            gridPane.add(label,0,5);

            Label flatLabel = new Label(worker.address.getFlat());
            gridPane.add(flatLabel,1,5);
        }
        else
        {
            label = new Label("Не заселён");
            gridPane.add(label,0,3);
        }
        root.setCenter(gridPane);
        getInfoStage.setScene(scene);
        getInfoStage.show();

    }
}

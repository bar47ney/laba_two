package Maybe;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Сергей on 04.04.2019.
 */
public class WorkersListWindow
{
    private int x;
    private int y = 2;
    public void display(Stage primaryStage, ArrayList<Worker> wl)
    {
        Stage getInfoStage = new Stage();
        getInfoStage.setResizable(false);
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,1200,700);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(44);
        gridpane.setVgap(5);
        getInfoStage.initModality(Modality.WINDOW_MODAL);
        getInfoStage.initOwner(primaryStage);

        Label label = new Label("Рабочие");
        gridpane.add(label,2,0);

        label = new Label("Имя");
        gridpane.add(label,0,1);

        label = new Label("Фамилия");
        gridpane.add(label,1,1);

        label = new Label("Улица");
        gridpane.add(label,2,1);

        label = new Label("Квартира");
        gridpane.add(label,3,1);

        label = new Label("Дом");
        gridpane.add(label,4,1);

        label = new Label("Место работы");
        gridpane.add(label,5,1);

        label = new Label("Статус");
        gridpane.add(label,6,1);

        Iterator<Worker> iter = wl.iterator();
        while (iter.hasNext())
        {
            Worker wor = iter.next();

            x = 0;

            label = new Label(wor.getFirstName());
            gridpane.add(label,x,y);

            x++;

            label = new Label(wor.getLastName());
            gridpane.add(label,x,y);

            label = new Label(wor.getActivity());
            gridpane.add(label,5,y);

            label = new Label(wor.getStatus());
            gridpane.add(label,6,y);

            if(wor.address != null)
            {
                x++;

                label = new Label(wor.address.getStreet());
                gridpane.add(label,x,y);

                x++;

                label = new Label(wor.address.getHouse());
                gridpane.add(label,x,y);

                x++;

                label = new Label(wor.address.getFlat());
                gridpane.add(label,x,y);
            }
            else
            {
                label = new Label("Нет адреса");
                gridpane.add(label,3,y);
            }

            y++;

        }

        root.setCenter(gridpane);
        getInfoStage.setScene(scene);
        getInfoStage.show();
    }
}

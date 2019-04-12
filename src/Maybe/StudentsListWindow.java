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
public class StudentsListWindow
{
    private int x;
    private int y = 2;
    public void display(Stage primaryStage, ArrayList<Student> sl)
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

        Label label = new Label("Студенты");
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

        label = new Label("Место учёбы");
        gridpane.add(label,5,1);

        label = new Label("Статус");
        gridpane.add(label,6,1);

        Iterator <Student> iter = sl.iterator();
        while (iter.hasNext())
            {
                Student stu = iter.next();

                x = 0;

                label = new Label(stu.getFirstName());
                gridpane.add(label,x,y);

                x++;

                label = new Label(stu.getLastName());
                gridpane.add(label,x,y);

                label = new Label(stu.getActivity());
                gridpane.add(label,5,y);

                label = new Label(stu.getStatus());
                gridpane.add(label,6,y);

                if(stu.address != null)
                {
                    x++;

                    label = new Label(stu.address.getStreet());
                    gridpane.add(label,x,y);

                    x++;

                    label = new Label(stu.address.getHouse());
                    gridpane.add(label,x,y);

                    x++;

                    label = new Label(stu.address.getFlat());
                    gridpane.add(label,x,y);
                }
                else
                {
                    label = new Label("Нет адреса");
                    gridpane.add(label,2,y);
                }

                y++;

            }

        root.setCenter(gridpane);
        getInfoStage.setScene(scene);
        getInfoStage.show();
    }
}

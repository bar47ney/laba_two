package Maybe; /**
 * Created by Сергей on 30.03.2019.
 */



import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application
{
    public void start(Stage primaryStage)
    {
        ArrayList<Student> sl = new ArrayList<Student>();
        ArrayList<Worker> wl = new ArrayList<Worker>();
        Student student = new Student();
        Worker worker = new Worker();
        MainWindow window = new MainWindow();
        window.display(primaryStage, student, worker, sl, wl);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

package Maybe; /**
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
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainWindow
{
    public void display(Stage primaryStage, Student student, Worker worker, ArrayList<Student> sl, ArrayList<Worker> wl )
    {
        try {
            primaryStage.setResizable(false);
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 600, 240);
            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(10));
            gridpane.setHgap(12);
            gridpane.setVgap(8);

            Label label = new Label("Студент");
            gridpane.add(label, 0, 0);

            label = new Label("Имя:");
            gridpane.add(label, 0, 1);

            TextField studentFirstNameField = new TextField();
            gridpane.add(studentFirstNameField, 1, 1);

            label = new Label("Фамилия:");
            gridpane.add(label, 0, 2);

            TextField studentLastNameField = new TextField();
            gridpane.add(studentLastNameField, 1, 2);

            label = new Label("Место учёбы:");
            gridpane.add(label, 0, 3);

            TextField studentActivityField = new TextField();
            gridpane.add(studentActivityField, 1, 3);

            Button moveInStudentButton = new Button("Адрес");
            gridpane.add(moveInStudentButton, 0, 4);

            Button moveOutStudentButton = new Button("Выселить");
            gridpane.add(moveOutStudentButton, 1, 4);

            Button getInfoAboutStudentButton = new Button("save info");
            getInfoAboutStudentButton.setPrefSize(160,120);
            gridpane.add(getInfoAboutStudentButton, 0, 5);

            label = new Label("Работник");
            gridpane.add(label, 4, 0);

            label = new Label("Имя");
            gridpane.add(label, 4, 1);

            TextField workerFirstNameField = new TextField();
            gridpane.add(workerFirstNameField, 5, 1);

            label = new Label("Фамилия");
            gridpane.add(label, 4, 2);

            TextField workerLastNameField = new TextField();
            gridpane.add(workerLastNameField, 5, 2);

            label = new Label("Место работы");
            gridpane.add(label, 4, 3);

            TextField workerActivityField = new TextField();
            gridpane.add(workerActivityField, 5, 3);

            Button moveInWorkerButton = new Button("Адрес");
            gridpane.add(moveInWorkerButton, 4, 4);

            Button moveOutWorkerButton = new Button("Выселить");
            gridpane.add(moveOutWorkerButton, 5, 4);

            Button getInfoAboutWorkerButton = new Button("save info");
            getInfoAboutWorkerButton.setPrefSize(160,120);
            gridpane.add(getInfoAboutWorkerButton, 4, 5);

            Button study = new Button("Учиться");
            gridpane.add(study, 1, 5);

            Button work = new Button("Работать");
            gridpane.add(work, 5, 5);

            Button addSt = new Button("Add student");
            addSt.setPrefSize(180,180);
            gridpane.add(addSt, 3, 5);

            Button addWo = new Button("Add worker");
            addWo.setPrefSize(180,180);
            gridpane.add(addWo, 3, 4);

            Button listStudents = new Button("List students");
            listStudents.setPrefSize(180,180);
            gridpane.add(listStudents, 3, 1);

            Button listWorkers = new Button("List workers");
            listWorkers.setPrefSize(180,180);
            gridpane.add(listWorkers, 3, 0);

            Button changeInfoButton = new Button("Change info");
            changeInfoButton.setPrefSize(180,180);
            gridpane.add(changeInfoButton, 3, 2);

            changeInfoButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    ChangeInfo windowChange = new ChangeInfo();
                    windowChange.display(primaryStage, sl, student, wl, worker);
                }
            });

            moveInStudentButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    MoveInWindow moveInWindow = new MoveInWindow();
                    moveInWindow.display(primaryStage, student);
                }
            });

            moveInWorkerButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    MoveInWindow moveInWindow = new MoveInWindow();
                    moveInWindow.display(primaryStage, worker);
                }
            });

            moveOutStudentButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event)
                {
                    student.moveOut();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Выселен!");
                    alert.showAndWait();
                }
            });

            moveOutWorkerButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    worker.moveOut();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Выселен!");
                    alert.showAndWait();
                }
            });

            listStudents.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    StudentsListWindow studLW = new StudentsListWindow();
                    studLW.display(primaryStage, sl);
                }
            });

            listWorkers.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                   WorkersListWindow workLW = new WorkersListWindow();
                   workLW.display(primaryStage, wl);
                }
            });

            addSt.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event)
                {
                    Student buf_stud = new Student();
                    buf_stud.copy(student);
                    buf_stud.moveIn();
                    if(student.address != null)
                    {
                        buf_stud.address.copy(student.address);
                    }
                    else
                    {
                        buf_stud.moveOut();
                    }
                    sl.add(buf_stud);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Добавлен студент!");
                    alert.showAndWait();
                }
            });

            addWo.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event)
                {
                    Worker buf_work = new Worker();
                    buf_work.copy(worker);
                    buf_work.moveIn();
                    if(worker.address != null)
                    {
                        buf_work.address.copy(worker.address);
                    }
                    else
                    {
                        buf_work.moveOut();
                    }
                    wl.add(buf_work);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Добавлен рабочий!");
                    alert.showAndWait();
                }
            });

            getInfoAboutStudentButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    student.setFirstName(studentFirstNameField.getText());
                    student.setLastName(studentLastNameField.getText());
                    if(student.isBoolStatus() == false)
                    {
                        student.setActivity("Нет учёбы");
                    }
                    else
                    {
                       student.setActivity(studentActivityField.getText());
                    }
                    StudentReportWindow getInfoAboutStudentWindow = new StudentReportWindow();
                    getInfoAboutStudentWindow.display(primaryStage, student);
                }
            });

            getInfoAboutWorkerButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    worker.setFirstName(workerFirstNameField.getText());
                    worker.setLastName(workerLastNameField.getText());
                    if(worker.isBoolStatus() == false)
                    {
                        worker.setActivity("Нет работы");
                    }
                    else
                    {
                        worker.setActivity(workerActivityField.getText());
                    }
                    WorkerReportWindow getInfoAboutWorkerWindow = new WorkerReportWindow();
                    getInfoAboutWorkerWindow.display(primaryStage, worker);
                }
            });

            study.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    if(student.isBoolStatus() == false)
                    {
                        alert.setContentText(student.study_yes());
                        student.setBoolStatus(true);
                        student.setStatus("Учусь");
                    }
                    else
                    {
                        alert.setContentText(student.study_no());
                        student.setBoolStatus(false);
                        student.setStatus("Не учусь");
                    }
                    alert.showAndWait();
                }
            });

           work.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    if(worker.isBoolStatus() == false)
                    {
                        alert.setContentText(worker.workYes());
                        worker.setBoolStatus(true);
                        worker.setStatus("Работаю");
                    }
                    else
                    {
                        alert.setContentText(worker.workNo());
                        worker.setBoolStatus(false);
                        worker.setStatus("Не работаю");
                    }
                    alert.showAndWait();
                }
            });

            root.setCenter(gridpane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

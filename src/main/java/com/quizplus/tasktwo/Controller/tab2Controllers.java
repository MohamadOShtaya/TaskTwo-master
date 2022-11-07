package com.quizplus.tasktwo.Controller;


import com.quizplus.tasktwo.Main;
import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import com.quizplus.tasktwo.Service.studentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class tab2Controllers {
    public static int id;
    List<Student> students;
    ObservableList<String> ListObserv = FXCollections.observableArrayList();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    StudentRepo studentRepo = new StudentRepo(entityManager);
    studentService studentService = new studentService(studentRepo);

    @FXML
    private ListView<String> ListView;

    @FXML
    private TextField txt;

    @FXML
    void Add(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addStudent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Add Course !");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Deleate(ActionEvent event) {
        try {
            if(ListView.getSelectionModel().getSelectedIndex()>=0){
                int index = ListView.getSelectionModel().getSelectedIndex();
                int studentId = students.get(index).getStudentId();
                try{
                    System.out.println(studentId);
                    studentService.deleateById(studentId);
                    ListView.getItems().remove(index);

                }
                catch (Exception ex){
                    System.out.println("this id has been alredy deleted");

                }

            }
            else {
                String str = txt.getText();
                int num = Integer.parseInt(str);
                try{
                    System.out.println(num);
                    studentService.deleateById(num);
                }
                catch (Exception ex){
                    System.out.println("this id has been alredy deleted");
                }
            }

        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("please select student or enter student ID");
            alert.show();
        }


    }

    @FXML
    void Get(ActionEvent event) {
        students = studentService.findall();

        for(int i=0;i<students.size();i++){
            ListObserv.add(students.get(i).getStudentName());
        }
        for (int i=0;i<ListObserv.size();i++){
            ListView.getItems().add(ListObserv.get(i));
        }
    }

    @FXML
    public int Update(ActionEvent event) throws IOException {
        try {
            int index = ListView.getSelectionModel().getSelectedIndex();
            id = students.get(index).getStudentId();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UpdateStudent.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setTitle("Update Student !");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("please select student");
            alert.show();
        }

        return id;
    }

}

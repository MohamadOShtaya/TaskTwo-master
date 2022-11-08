package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;

public class AddCourse {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    CourseService courseService = new CourseService(courseRepo);





    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTeacher;
    @FXML
    private CheckBox yes,no;

    @FXML
    void save(ActionEvent event) throws ParseException {
        try {
            String courseName = txtName.getText();
            String courseTeacher = txtTeacher.getText();
            int capacity = Integer.parseInt(txtCapacity.getText());
            boolean IsAva;
            if(yes.isSelected()){
                 IsAva = true;
            }
            else {
                 IsAva = false;
            }

            Course course = new Course(courseName,courseTeacher,capacity,null,IsAva);
            courseService.save(course);
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("Please enter your new course data ");
            alert.show();
        }


    }

}

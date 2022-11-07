package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCourse {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    com.quizplus.tasktwo.Service.courseService courseService = new courseService(courseRepo);

    @FXML
    private Button btn;

    @FXML
    private TextField txtAvilable;

    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTeacher;

    @FXML
    void save(ActionEvent event) throws ParseException {
        String courseName = txtName.getText();
        String courseTeacher = txtTeacher.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());
        boolean IsAva = Boolean.parseBoolean(txtAvilable.getText());
        Course course = new Course(courseName,courseTeacher,capacity,null,IsAva);
        courseService.save(course);

    }

}

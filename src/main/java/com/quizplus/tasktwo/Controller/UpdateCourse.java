package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class UpdateCourse {

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

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    CourseRepo courseRepo = new CourseRepo(entityManager);
    com.quizplus.tasktwo.Service.courseService courseService = new courseService(courseRepo);

    public static  int id;



    public void OnClickUpdate() throws IOException {

        String courseName = txtName.getText();
        String courseTeacher = txtTeacher.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());
        boolean IsAva = Boolean.parseBoolean(txtAvilable.getText());
        tab1Controllers tab1Controllers = new tab1Controllers();
        int id = tab1Controllers.id;
        Course tempCourse = entityManager.find(Course.class,id);
        entityManager.getTransaction().begin();
        tempCourse.setCourseName(courseName);
        tempCourse.setCourseCapacity(capacity);
        tempCourse.setTeacherName(courseTeacher);
        tempCourse.setIsAvilable(IsAva);
        entityManager.getTransaction().commit();

    }
}

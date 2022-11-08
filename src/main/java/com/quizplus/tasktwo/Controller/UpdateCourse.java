package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Date;

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
    CourseService courseService = new CourseService(courseRepo);
    public static  int id;
    public void OnClickUpdate() throws IOException {
        try {
            String courseName = txtName.getText();
            String courseTeacher = txtTeacher.getText();
            int capacity = Integer.parseInt(txtCapacity.getText());
            boolean IsAva = Boolean.parseBoolean(txtAvilable.getText());
            String s = txtDate.getText();
            Date date=new Date();
            date.parse(s);
            tabCoursesControllers tab1Controllers = new tabCoursesControllers();
            int id = tab1Controllers.id;
            Course tempCourse = entityManager.find(Course.class,id);
            entityManager.getTransaction().begin();
            if(txtName!=null){
                tempCourse.setCourseName(courseName);
            }
            else {
                tempCourse.setCourseName(tempCourse.getCourseName());
            }
            if(txtTeacher!=null){
                tempCourse.setTeacherName(courseTeacher);
            }
            else {
                tempCourse.setTeacherName(tempCourse.getTeacherName());
            }
            if(txtCapacity!=null){
                tempCourse.setCourseCapacity(capacity);
            }
            else {
                tempCourse.setCourseCapacity(tempCourse.getCourseCapacity());
            }

            if(txtAvilable!=null){
                tempCourse.setIsAvilable(IsAva);
            }
            else {
                tempCourse.setIsAvilable(tempCourse.isAvilable());
            }

            entityManager.getTransaction().commit();

        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("Plesae enter your update in textFields");
            alert.show();
        }


    }
}

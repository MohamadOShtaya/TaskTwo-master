package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateStudent {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    CourseService courseService = new CourseService(courseRepo);
    @FXML
    private Label txt;

    @FXML
    private TextField txtDep;

    @FXML
    private TextField txtGPA;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    void Update(ActionEvent event) {
        try {
            String studentName = txtName.getText();
            String Gender = txtGender.getText();
            double GPA = Double.parseDouble(txtGPA.getText());
            String department = txtDep.getText();
            tabStudentsControllers tab1Controllers = new tabStudentsControllers();
            int id = tabStudentsControllers.id;
            Student tempStudent = entityManager.find(Student.class,id);
            entityManager.getTransaction().begin();
            if(txtName!=null){
                tempStudent.setStudentName(studentName);
            }
            else {
                tempStudent.setStudentName(tempStudent.getStudentName());
            }
            if(txtGender!=null){
                tempStudent.setStudentGender(Gender);
            }
            else {
                tempStudent.setStudentGender(tempStudent.getStudentGender());
            }
            if(txtGPA!=null){
                tempStudent.setStudentAvg(GPA);

            }
            else {
                tempStudent.setStudentAvg(tempStudent.getStudentAvg());

            }
            if(txtDep!=null){
                tempStudent.setStudentDepartmentName(department);
            }
            else {
                tempStudent.setStudentDepartmentName(tempStudent.getStudentDepartmentName());
            }
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("please enter your update student info in text fields");
            alert.show();
        }

    }

}

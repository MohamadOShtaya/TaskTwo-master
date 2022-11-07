package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateStudent {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    CourseRepo courseRepo = new CourseRepo(entityManager);
    com.quizplus.tasktwo.Service.courseService courseService = new courseService(courseRepo);
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
        String studentName = txtName.getText();
        String Gender = txtGender.getText();
        double GPA = Double.parseDouble(txtGPA.getText());
        String department = txtDep.getText();
        tab2Controllers tab1Controllers = new tab2Controllers();
        int id = tab2Controllers.id;
        Student tempStudent = entityManager.find(Student.class,id);
        entityManager.getTransaction().begin();
        tempStudent.setStudentName(studentName);
        tempStudent.setStudentAvg(GPA);
        tempStudent.setStudentDepartmentName(department);
        tempStudent.setStudentGender(Gender);
        entityManager.getTransaction().commit();
    }

}

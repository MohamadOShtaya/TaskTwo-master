package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import com.quizplus.tasktwo.Service.studentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddStudent {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    StudentRepo repo = new StudentRepo(entityManager);
    studentService studentService = new studentService(repo);
    @FXML
    private TextField txtAvg;

    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    void SaveStudent(ActionEvent event) {
       String sName = txtName.getText();
       String gender = txtGender.getText();
       String dep = txtDepartment.getText();
       double avg = Double.parseDouble(txtAvg.getText());
       Student student = new Student(sName,gender,avg,dep);
        studentService.save(student);

    }
}

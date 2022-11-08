package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import com.quizplus.tasktwo.Service.CourseService;
import com.quizplus.tasktwo.Service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AddStudentCourse {

    static int  id ;
    @FXML
    private ComboBox<String> combo;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CourseRepo courseRepo = new CourseRepo(entityManager);
    CourseService courseService = new CourseService(courseRepo);
    StudentRepo studentRepo = new StudentRepo(entityManager);
    StudentService studentService = new StudentService(studentRepo);
    List<Course>  courses = new ArrayList<>();
    ObservableList<String> ListObserv = FXCollections.observableArrayList();
    ArrayList<Student> students = new ArrayList<>();


    public void fillCourses() {
          courses= courseService.findall();
        List<Course> listCourse = new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            ListObserv.add(courses.get(i).getCourseName());
        }
        for (int i=0;i<ListObserv.size();i++){
            combo.getItems().add(ListObserv.get(i));
        }

    }

    public void addStudent() {
        int index = combo.getSelectionModel().getSelectedIndex();
        id = courses.get(index).getCourseId();
        System.out.println(id);
        tabStudentsControllers tab1Controllers = new tabStudentsControllers();
        int Sid = tab1Controllers.id;
        Course tempCourse = entityManager.find(Course.class,id);
        System.out.println(Sid);
        students.add(studentService.findById(Sid));
        tempCourse.setStudents(students);
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        System.out.println(students.toString());

    }
}

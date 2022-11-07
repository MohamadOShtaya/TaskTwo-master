package com.quizplus.tasktwo;


import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.courseService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CourseRepo courseRepo = new CourseRepo(entityManager);
        courseService courseService = new courseService(courseRepo);
        Course c1 = new Course(0,"java","nael",10,null,true);
       // Course c12 = new Course(38,"newJava","nael",9,null,false);
//        //courseService.save(c1);
//        c1.setTeacherName("new teacher");
//        courseService.Update(c1);

        launch();
    }
}
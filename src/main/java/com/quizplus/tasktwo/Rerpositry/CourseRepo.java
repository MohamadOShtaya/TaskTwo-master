package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public CourseRepo(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    public List<Course> finaAll() {
        entityManager.createQuery("from course").getResultList();
        return entityManager.createQuery("from course ").getResultList();
    }
    public void save(Course theCourse) {
         entityManager.getTransaction().begin();
         entityManager.persist(theCourse);

         entityManager.getTransaction().commit();
    }

    public Course findById(int theId) {
        Course course = entityManager.find(Course.class,theId);
        return course;

    }
    public void Put(Course course){

        entityManager.createQuery("Update course set courseName='\" + course.getCourseName() + \"',and set teacherName='\" +   course.getTeacherName() + \"',and set courseCapacity='\" + course.getCourseCapacity() + \"',and set date_='\" + course.getDate() + \"' ,and set isAvilable='\" + course.isAvilable() + \"' where courseId ='\" +  course.getCourseId() + \"'\";")
                .executeUpdate();
    }
    public void deleteById(int courseId){
        entityManager.getTransaction().begin();
        try {
            Course course = entityManager.find(Course.class,courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            System.out.println("Deleated");
        }
        catch (Exception ex){
            System.out.println("Course has already been delated ");
        }

    }
}

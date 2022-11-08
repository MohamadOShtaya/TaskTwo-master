package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class StudentRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public StudentRepo(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<Student> finaAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("from student").getResultList();
        entityManager.getTransaction().commit();
        return entityManager.createQuery("from student").getResultList();
    }
    public void save(Student theStudent) {
        entityManager.getTransaction().begin();
        entityManager.persist(theStudent);
        entityManager.getTransaction().commit();
    }

    public Student findById(int theId) {
        Student student = entityManager.find(Student.class,theId);
        return student;

    }
    public void deleteById(int courseId){
        entityManager.getTransaction().begin();
        try {
            Student student = entityManager.find(Student.class,courseId);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
            System.out.println("Deleated");
        }
        catch (Exception ex){
            System.out.println("student has already been Deleated ");
        }
    }
}

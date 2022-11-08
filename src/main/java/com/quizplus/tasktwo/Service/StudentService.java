package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import java.util.List;
public class StudentService {
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public List<Student> findall() {
        return studentRepo.finaAll();
    }
    public Student findById(int theId) {
        return studentRepo.findById(theId);
    }
    public void save(Student theStudent) {
        studentRepo.save(theStudent);
    }
    public void deleateById(int id){
        studentRepo.deleteById(id);
    }

}

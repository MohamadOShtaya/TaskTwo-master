package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;

import java.util.List;

public class courseService {
    private CourseRepo courseRepo;
    public courseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }
    public List<Course> findall() {
        return courseRepo.finaAll();
    }
    public Course findById(int theId) {
        return courseRepo.findById(theId);
    }
    public void save(Course course){
        course.setCourseId(0);
        courseRepo.save(course);
    }
    public Course Update(Course course){
       //update course set courseCapacity=?, courseName=?, date_=?, isAvilable=?, teacherName=? where courseId=?
        //String query = "Update masterusertable set username='" + txtName.Text + "',and set password='" + txtpassword.Text + "',and set phoneno='" + txtphoneno.Text + "',and set adress='" + rtxtAdress.Text + "' where userid ='" + txtuserid.Text + "'";
        courseRepo.save(course);
        return course;
    }

    public void deleateById(int theId) {
        courseRepo.deleteById(theId);
    }

}

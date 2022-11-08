package com.quizplus.tasktwo.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "student")
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "studentGender")
    private String studentGender;
    @Column(name = "studentAvg")
    private double studentAvg;
    @Column(name = "studentDepartmentName")
    private String studentDepartmentName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns=@JoinColumn(name = "course_id")
    )
    List<Course> courses = new ArrayList<>();


    public Student(){

    }

    public Student(String studentName, String studentGender, double studentAvg, String studentDepartmentName, List<Course> courses) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAvg = studentAvg;
        this.studentDepartmentName = studentDepartmentName;
        this.courses = courses;
    }

    public Student(String studentName, String studentGender, double studentAvg, String studentDepartmentName) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAvg = studentAvg;
        this.studentDepartmentName = studentDepartmentName;
    }
}

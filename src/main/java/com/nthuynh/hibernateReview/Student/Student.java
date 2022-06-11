package com.nthuynh.hibernateReview.Student;
//create student class entity
import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    private long student_id;
    private String name;
    private String country;
    private String student_code;

    public Student(){

    }

    public Student(long student_id,String name,String country,String student_code){
        this.setStudent_id(student_id);
        this.setStudent_code(student_code);
        this.setCountry(country);
        this.setName(name);
    }

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }
}

package com.nthuynh.hibernateReview.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.awt.print.Book;


public class StudentManager {
    protected SessionFactory sessionFactory;

    protected void setup(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch(Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    protected void exit(){
        sessionFactory.close();
    }
    protected void create(){
        Student student = new Student();
        student.setStudent_code("20181200");
        student.setName("Kai Havert");
        student.setCountry("UK");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
    protected void read(){
        Session session = sessionFactory.openSession();
        long studentId = 1;
        Student student = session.get(Student.class,studentId);
        if(student != null){
            System.out.println(student.getName());
            System.out.println(student.getStudent_code());
            System.out.println(student.getCountry());
        }else{
            System.out.println("Invalid student");
        }
        session.close();
    }
    public void update(){
        Student student = new Student();
        long studentId = 5;
        student.setStudent_id(studentId);
        student.setStudent_code("20181200");
        student.setName("Kai Havert");
        student.setCountry("Germany");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(){
        Session session = sessionFactory.openSession();
        long studentId = 3;
        Student student = new Student();
        student.setStudent_id(studentId);
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }
    public static void main(String[] args){
        StudentManager studentManager = new StudentManager();
        studentManager.setup();
        studentManager.delete();
        studentManager.exit();
    }
}

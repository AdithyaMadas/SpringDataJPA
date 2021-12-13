package com.madas.jpa.repository;

import com.madas.jpa.entity.Passport;
import com.madas.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager manager;

    public void saveWithPassport(String name) {
        Passport passport = new Passport("Z1234");
        manager.persist(passport);

        Student student = new Student(name);
        student.setPassport(passport);
        manager.persist(student);
    }

    public Student find(int id) {
        Student student = manager.find(Student.class, id);
        return student;
    }


}

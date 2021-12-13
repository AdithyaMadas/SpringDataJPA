package com.madas.jpa.repository;

import com.madas.jpa.entity.Passport;
import com.madas.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PassportRepository {

    @Autowired
    EntityManager manager;

    public void saveWithStudent(String name) {
        Student student = new Student(name);
        manager.persist(student);

        Passport passport = new Passport("Z5678");
        student.setPassport(passport);
        passport.setStudent(student);
        manager.persist(passport);
    }

    public Passport find(int id) {
        Passport passport = manager.find(Passport.class, id);
        return passport;
    }


}

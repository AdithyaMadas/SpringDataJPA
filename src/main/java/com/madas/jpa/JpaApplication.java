package com.madas.jpa;

import com.madas.jpa.entity.Passport;
import com.madas.jpa.entity.Student;
import com.madas.jpa.repository.CourseRepository;
import com.madas.jpa.repository.PassportRepository;
import com.madas.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PassportRepository passportRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
        logger.info(String.valueOf(courseRepository.findById(1001)));
/*        courseRepository.deleteById(1001);
        logger.info(String.valueOf(courseRepository.save(new Course("DAA"))));
        courseRepository.playingWithEntityManager();
        logger.info("{}", courseRepository.jpql_simple());
        logger.info("{}", courseRepository.jpql_typed());
        logger.info("{}", courseRepository.jpql_where());

        logger.info("{}", courseRepository.namedQuery());
        logger.info("{}", courseRepository.nativeQuery_select());
        logger.info("{}", courseRepository.nativeQuery_selectById(1001));
        logger.info("{}", courseRepository.nativeQuery_updateAllModifiedTimeStamp());*/
/*
        studentRepository.saveWithPassport("Qwerty");
        logger.info("{} -> " + studentRepository.find(2001));*/

        logger.info("{} ", passportRepository.find(2));
        passportRepository.saveWithStudent("Kriti");

    }
}

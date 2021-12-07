package com.madas.jpa;

import com.madas.jpa.dao.CourseRepository;
import com.madas.jpa.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(String.valueOf(repository.findById(1001)));
/*        repository.deleteById(1001);
        logger.info(String.valueOf(repository.save(new Course("DAA"))));
        repository.playingWithEntityManager();
        logger.info("{}", repository.jpql_simple());
        logger.info("{}", repository.jpql_typed());
        logger.info("{}", repository.jpql_where());

        logger.info("{}", repository.namedQuery());
        logger.info("{}", repository.nativeQuery_select());
        logger.info("{}", repository.nativeQuery_selectById(1001));
        logger.info("{}", repository.nativeQuery_updateAllModifiedTimeStamp());*/

    }
}

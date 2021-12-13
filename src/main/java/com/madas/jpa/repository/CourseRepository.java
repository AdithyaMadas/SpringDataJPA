package com.madas.jpa.repository;

import com.madas.jpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager manager;

    public Course findById(int id) {
        return manager.find(Course.class, id);
    }

    public void deleteById(int id) {
        Course byId = findById(id);
        manager.remove(byId);
    }

    public Course save(Course course) {
        /*if (course.getId() != null) {
            manager.persist(course);
        } else {
            manager.merge(course);
        }*/

        return manager.merge(course);
    }

    public List jpql_simple() {
        Query simpleQuery = manager.createQuery("select c from Course c");
        return simpleQuery.getResultList();
    }

    public List<Course> jpql_typed() {
        TypedQuery<Course> typedQuery = manager.createQuery("select c from Course c", Course.class);
        return typedQuery.getResultList();
    }

    public List<Course> jpql_where() {
        Query query = manager.createQuery("select c from Course c where name like '%A%'");
        return query.getResultList();
    }

    public List<Course> namedQuery() {
        TypedQuery<Course> select_all = manager.createNamedQuery("select_all", Course.class);
        return select_all.getResultList();
    }

    public List<Course> nativeQuery_select() {
        Query nativeQuery = manager.createNativeQuery("select * from course_details", Course.class);
        return nativeQuery.getResultList();
    }

    public List<Course> nativeQuery_selectById(int id) {
        Query nativeQuery = manager.createNativeQuery("select * from course_details where id = :id", Course.class);
        nativeQuery.setParameter("id", id);
        return nativeQuery.getResultList();
    }

    //better to use native queries here than JPA, because to update all the rows, we need to call each row one by one in JPA
    public int nativeQuery_updateAllModifiedTimeStamp() {
        Query nativeQuery = manager.createNativeQuery("update course_details set last_updated_date=sysdate()");
        return nativeQuery.executeUpdate();
    }
    public void playingWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        manager.persist(course1);

        Course course2 = new Course("Angular Js in 100 Steps");
        manager.persist(course2);

        manager.flush();
//        even after making changes to the object, the changes are put into DB because of the transactional nature.
        course1.setName("Web Services in 100 Steps - Updated");
        course2.setName("Angular Js in 100 Steps - Updated");
        manager.flush();

//        after calling detach, even if you mkae changes to the object, they are not written to the DB
        manager.detach(course1);
//       manager.remove(course1);
        course1.setName("Web Services in 100 Steps - Updated123");
        course2.setName("Angular Js in 100 Steps - Updated123");
//        manager.flush();

//        the below method, calls detach on all the objects managed by entity manager. We can use this
//        instead of calling detach on each object.
//        manager.clear();
//        refresh reads values from the database and then puts those values into the variables. For example, for course2 object, Updated123 was set, but after calling
//        refresh, the Name of course2 is set back to Updated
        manager.refresh(course2);
//        manager.flush();
    }


}

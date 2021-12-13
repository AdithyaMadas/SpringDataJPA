package com.madas.jpa.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String number;

    //the mappedBy tells Hibernate that the passport relationship is owned by student, with variable named passport. So it doesn't create student_id field in the table
    @OneToOne(mappedBy = "passport")
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    public Passport() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String name) {
        this.number = name;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}

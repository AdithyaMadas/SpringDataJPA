package com.madas.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String number;

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

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}

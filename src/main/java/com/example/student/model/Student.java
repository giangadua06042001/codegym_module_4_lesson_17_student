package com.example.student.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    private String address;
    private String email;
    private double mark;

    public Student() {
    }

    public Student(String name, String number, String address, String email, double mark) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.mark = mark;
    }

    public Student(Long id, String name, String number, String address, String email, double mark) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

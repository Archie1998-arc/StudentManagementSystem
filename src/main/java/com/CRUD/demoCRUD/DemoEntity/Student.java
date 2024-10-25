package com.CRUD.demoCRUD.DemoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private long roll;
    private String name;
    private int age;
    private String stream;

    public Student(){}
    public Student(long roll,String name, int age,String stream){
        super();
        this.roll =roll;
        this.name = name;
        this.age =age;
        this.stream =stream;
    }
    public long getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }



}

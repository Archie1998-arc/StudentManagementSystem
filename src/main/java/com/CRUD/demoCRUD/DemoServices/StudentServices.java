package com.CRUD.demoCRUD.DemoServices;

import com.CRUD.demoCRUD.DemoEntity.Student;

import java.util.List;

public interface StudentServices {
    List<Student> getStudents();

    void createStudent(Student student);

    void deleteStudent(long l);

    void updateStudent(Student student);
}

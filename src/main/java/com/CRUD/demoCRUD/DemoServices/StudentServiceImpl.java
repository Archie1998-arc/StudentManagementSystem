package com.CRUD.demoCRUD.DemoServices;

import com.CRUD.demoCRUD.DemoDAO.StudentDao;
import com.CRUD.demoCRUD.DemoEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServices {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudents() {

        return studentDao.findAll();
    }

    @Override
    public void createStudent(Student student) {
        studentDao.save(student);
    }

    @Transactional
    @Override
    public void deleteStudent(long id) {
        Optional<Student> studentOpt = studentDao.findById(id);
        if(studentOpt.isPresent()) {
            studentDao.deleteById(id);
        }
    }
    @Override
    public void updateStudent (Student student){
        Optional<Student> existingStudent = studentDao.findById(student.getRoll());

        if (existingStudent.isPresent()) {
            // Update the existing student details
            Student updatedStudent = existingStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setAge(student.getAge());
            updatedStudent.setStream(student.getStream());
            studentDao.save(updatedStudent);
        }
    }
}


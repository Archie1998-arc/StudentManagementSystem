package com.CRUD.demoCRUD.demoController;

import com.CRUD.demoCRUD.DemoEntity.Student;
import com.CRUD.demoCRUD.DemoServices.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
public class StudentController {

  @Autowired
 StudentServices studentServices;

 @GetMapping("/home")
 public ResponseEntity<HttpStatus> getHomePage(){
     try{
         return new ResponseEntity<>(HttpStatus.OK);
     }catch (HttpServerErrorException.InternalServerError e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

     }
 }
    @GetMapping("/test")
    public String getTestStatus(){
        return "Test Successful";
    }
 @GetMapping("/students")
 public List<Student> getStudents(){
    return studentServices.getStudents();

 }
 @PostMapping("/student")
 public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student){
     try{
         studentServices.createStudent(student);
         return new ResponseEntity<>(HttpStatus.OK);
     }catch (HttpServerErrorException.InternalServerError e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

     }
 }
 @DeleteMapping ("/student/{roll}")
 public ResponseEntity<HttpStatus>  deleteStudent(@PathVariable String roll){
     try{
         long studentId = Long.parseLong(roll);
         studentServices.deleteStudent(studentId);
         return new ResponseEntity<>(HttpStatus.OK);
     }catch (HttpServerErrorException.InternalServerError e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

     }
 }
  @PutMapping("/student")
    public ResponseEntity<HttpStatus>  updateStudent(@RequestBody  Student student){
        try{
            studentServices.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (HttpServerErrorException.InternalServerError e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}

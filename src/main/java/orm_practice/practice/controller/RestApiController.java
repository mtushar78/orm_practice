package orm_practice.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orm_practice.practice.model.Student;
import orm_practice.practice.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students =  studentRepository.findAll();
        return new ResponseEntity<List<Student>>(students,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> getStudentByID(@PathVariable(value = "id") int id){
        Optional<Student> student = studentRepository.findById(id);
        return new ResponseEntity<Optional<Student>>(student,new HttpHeaders(), HttpStatus.OK);
    }
}

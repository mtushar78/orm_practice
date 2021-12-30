package orm_practice.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orm_practice.practice.dto.BillInfoSdnJoinDto;
import orm_practice.practice.model.DemoTest;
import orm_practice.practice.model.Student;
import orm_practice.practice.repository.DemoRepository;
import orm_practice.practice.repository.JpaProjection;
import orm_practice.practice.repository.StudentRepository;
import orm_practice.practice.service.BillInfoService;
import orm_practice.practice.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    DemoRepository repository;
    @Autowired
    BillInfoService billInfoService;

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
   /* public ResponseEntity<StudentEntity> createOrUpdateStudent(@Valid @RequestBody StudentEntity student)
            throws RecordNotFoundException {
        StudentEntity updated = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }*/
   @PostMapping(value = "/post", consumes = "application/json", produces = "application/json" )
   public ResponseEntity<Student> createOrUpdateStudent(@Valid @RequestBody Student student ){
//        Student student1 = studentService.createRecord(student);
         Student student1 = studentRepository.save(student);

        return new ResponseEntity<Student>(student1, new HttpHeaders(),HttpStatus.CREATED);
   }

   @DeleteMapping(path = "/{id}")
   public String deleteEntity(@PathVariable ("id") Integer id){
       if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Status:"+HttpStatus.NO_CONTENT;
       }else{
           return "Status:"+HttpStatus.NOT_FOUND;
       }

   }

    @PostMapping(value = "/demo")
    public ResponseEntity<DemoTest> createOrUpdateStudent(@Valid @RequestBody DemoTest demoTest ) {
        DemoTest demoTest1 = repository.save(demoTest);
        return new ResponseEntity<DemoTest>(demoTest1, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping(value = "/demo")
    public ResponseEntity<List<DemoTest>> getDemo(){
        List<DemoTest> list =  repository.findAll();
        return new ResponseEntity<List<DemoTest>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/getData")
    public ResponseEntity<List<BillInfoSdnJoinDto>> getAllData(){
        List<BillInfoSdnJoinDto> list =  billInfoService.getData();
        return new ResponseEntity<List<BillInfoSdnJoinDto>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping(value = "/projection")
    public ResponseEntity<List<JpaProjection>> getAllDatap(){
        List<JpaProjection> list =  billInfoService.getDataWithProjection();
        return new ResponseEntity<List<JpaProjection>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}

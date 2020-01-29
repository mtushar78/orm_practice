package orm_practice.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orm_practice.practice.model.Student;
import orm_practice.practice.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createRecord(Student student){
        if(String.valueOf(student.getId()) ==null){
            System.out.println("null");
            student = studentRepository.save(student);
            return student;
        }else{
            System.out.println(" not null");
            Optional<Student> newStudent = Optional.of(new Student());
            if(newStudent.isPresent()){
                Student student1 = newStudent.get();
                student1.setFname(student.getFname());
                student1.setLname(student.getLname());
                student1.setEmail(student.getEmail());
                student1.setSemesteer(student.getSemesteer());
                return student1;
            }
            return student;
        }
    }
}

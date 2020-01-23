package orm_practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import orm_practice.practice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
}

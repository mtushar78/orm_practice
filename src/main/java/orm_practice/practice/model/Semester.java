package orm_practice.practice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Semester implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String semester_no;
    @OneToMany(mappedBy = "semester")
    @JsonManagedReference
    private List<Course> courses;

    @OneToMany(mappedBy = "semesteer")
    @JsonBackReference
    private List<Student> student;
}

package orm_practice.practice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String course_title;
    @ManyToOne
    @JoinColumn
    private Semester semester;

    public Course() {
    }

    public Course(String course_title, Semester semester) {
        this.course_title = course_title;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
    @JsonBackReference
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}


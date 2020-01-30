package orm_practice.practice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fname;
    private String email;
    private String lname;

    public Student(String fname, String email, String lname, Semester semesteer) {
        this.fname = fname;
        this.email = email;
        this.lname = lname;
        this.semesteer = semesteer;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
//    @JsonManagedReference
    public Semester getSemesteer() {
        return semesteer;
    }

    public void setSemesteer(Semester semesteer) {
        this.semesteer = semesteer;
    }

    @ManyToOne
    @JoinColumn
    private Semester semesteer;
}

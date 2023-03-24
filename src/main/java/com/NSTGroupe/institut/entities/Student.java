package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@ToString
@Data

public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_student;
    @NotBlank(message = "firstname is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "firstname name should be contains only alphabetic")
    @Column(name = "first_name", length = 60, nullable = false)
    private String firstname ;
    @NotBlank(message = "lastname is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "lastname should be contains only alphabetic")
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastname;
    private String city;
    private String postal_code;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date_of_birth;
    private String lieu_of_birth;
    private String level;
    private String gender;
    private String Nationality;
    private String tel;
    public String cne;
    private double moy;

}
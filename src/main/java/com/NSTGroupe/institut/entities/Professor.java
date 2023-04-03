package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "professor")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "firstname is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "firstname name should be contains only alphabetic")
    @Column(name = "first_name", length = 60, nullable = false)
    private String firstname ;
    @NotBlank(message = "lastname is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "lastname should be contains only alphabetic")
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastname;
    @Column(name = "email", nullable = false )
    @Email(message = "email invalid")
    private String email;
    private String cin;
   private String tel;
   private  String adresse;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date_of_birth;
    private String lieu;
    private String genre;
    private  String Nationality;
    private  String grade;
   private  String establishment;
   private String speciality;

    @JsonIgnore
    @ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY)
    private List<Module> modules ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sectorId", referencedColumnName = "id")
    private Professor professor;
}

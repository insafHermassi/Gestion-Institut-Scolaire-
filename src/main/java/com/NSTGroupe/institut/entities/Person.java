package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;
    @Data
    @Entity
    @Table(name = "person")
    @Inheritance(strategy= InheritanceType.JOINED)

    public abstract class Person implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "idPerson", unique = true, nullable = false)
        private Long idPerson;

        @Column(name = "gender", length = 45)
        private String gender;

        @NotBlank(message = "firstname is mandatory")
        @Pattern(regexp = "[a-zA-Z]+", message = "firstname name should be contains only alphabetic")
        @Column(name = "Firstname", length = 45)
        private String firstname;


        @NotBlank(message = "lastname is mandatory")
        @Pattern(regexp = "[a-zA-Z]+", message = "lastname should be contains only alphabetic")
        @Column(name = "Lastname", length = 45)
        private String lastname;

        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
        @Column(name = "DateOfBirth", length = 45)
        private Date dateOfBirth;


        @Column(name = "Email", length = 45)
        private String email;

        @Column(name = "Address", length = 45)
        private String address;

        @Column(name = "Telephone", length = 45)
        private String telephone;

        @Column(name = "CodePostal", length = 45)
        private String codePostal;

        @Column(name = "City", length = 45)
        private String city;
        @Column(name = "Pays", length = 45)
        private String pays;
        @Column(name = "active", length = 45)
        private boolean active;





    }

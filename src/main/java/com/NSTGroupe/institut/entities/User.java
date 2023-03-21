package com.NSTGroupe.institut.entities;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.persistence.*;
import java.io.Serializable;
    @Data
    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    @Table(name = "users")
    public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotBlank(message = "firstname is mandatory")
        @Pattern(regexp = "[a-zA-Z]+", message = "firstname name should be contains only alphabetic")
        @Column(name = "first_name", length = 60, nullable = false)
        private String firstname;

        @NotBlank(message = "lastname is mandatory")
        @Pattern(regexp = "[a-zA-Z]+", message = "lastname should be contains only alphabetic")
        @Column(name = "last_name", length = 60, nullable = false)
        private String lastname;

        @Column(name = "email", nullable = false )
        @Email(message = "email invalid")
        private String email;
        private String password;
}

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

        @NotBlank(message = "username is mandatory")
        @Pattern(regexp = "[a-zA-Z]+", message = "username name should be contains only alphabetic")
        @Column(name = "username", length = 60, nullable = false)
        private String username;



        @Column(name = "email", nullable = false )
        @Email(message = "email invalid")
        private String email;
        private String password;
}

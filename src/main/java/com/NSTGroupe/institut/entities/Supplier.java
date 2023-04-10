package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
    @GeneratedValue(strategy = IDENTITY)
        @Column(name = "idSupplier", unique = true, nullable = false)
        private int idSupplier;

       @Column(name = "Adress", length = 45)
        private String adress;

       @Column(name = "Email", length = 45)
        private String email;

       @Column(name = "city", length = 45)
        private String city;
        @Column(name = "Telephone", length = 45)
        private String telephone;

       @Column(name = "Name", length = 45)
        private String name;

       @Column(name = "actif", length = 45)
        private boolean actif;


}

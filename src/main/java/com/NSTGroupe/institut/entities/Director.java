package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
    @Entity
    @Table(name = "director")
    @PrimaryKeyJoinColumn(name = "idPerson")
    public class Director extends Person implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "Number_registration", length = 45)
        private String numberOfRegistration;

        @Column(name = "CIN", length = 45)
        private String cin;
        private Set<Person> persons = new HashSet<Person>(0);



}

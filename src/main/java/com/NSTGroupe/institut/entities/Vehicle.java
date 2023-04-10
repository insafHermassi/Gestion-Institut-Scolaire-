package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

    @Data
    @Entity
    @Table(name = "vehicle")
    public class Vehicle  {

        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "idVehicle", unique = true, nullable = false)
        private int idVehicle;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "Transport_id_transport", nullable = false)
        private Transport transport;
        @Column(name = "Number_Registration", length = 45)
        private String numberOfRegistration;
        @Column(name = "Model", length = 45)
        private String model;
        @Column(name = "Date_Buy", length = 10)
        private Date dateOfBuy;
        @Column(name = "actif", length = 45)
        private boolean actif;
        @Column(name = "Mark", length = 45)
        private String mark;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
        private Set<Driver> drivers = new HashSet<Driver>(0);


}

package com.NSTGroupe.institut.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Data
    @Entity
    @Table(name = "driver")
    @PrimaryKeyJoinColumn(name = "idPersonne")
    @NoArgsConstructor
    public class Driver extends Person implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "Number_registration", length = 45)
        private String numberOfRegistration;

        @Column(name = "CIN", length = 45)
        private String cin;
        @Temporal(TemporalType.DATE)
        @Column(name = "start_date_of_work", length = 10)
        private Date startDateOfWork;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "vehicle_idVehicle", nullable = false)
          private Vehicle vehicle;

    }




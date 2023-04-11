package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "administrators")
@PrimaryKeyJoinColumn(name = "idPerson")
public class Administrator extends Person implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long idAdministrator;
///private Double salary;
// private  String registration_number;
    @Column(name = "CIN", length = 45)
    private String cin;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date_of_work", length = 10)
    private Date startDateOfWork;
}

package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@ToString
@Table(name = "guardian")
@PrimaryKeyJoinColumn(name = "idPerson")
public class Guardian extends Person implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGuardian;
    @Column(name = "CIN", length = 45)

    private String cin;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date_of_work", length = 10)
    private Date startDateOfWork;
}
package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "responsibles")
@PrimaryKeyJoinColumn(name = "idPerson")
public class Responsible extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idResponsible;
    @Column(name = "CIN", length = 45)
    private String cin;
    @Column(name="linkParents")
    private String linkParents;
}

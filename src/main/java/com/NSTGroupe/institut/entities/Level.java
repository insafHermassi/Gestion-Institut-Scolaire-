package com.NSTGroupe.institut.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name ="levels")
        public class Level implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libellle;
    private String option;
    private String class_capability;
}

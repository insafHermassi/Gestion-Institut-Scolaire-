package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
@Table(name ="levels")
        public class Level implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libelle;
    private String option;

   @JsonIgnore
    @OneToMany(mappedBy = "level",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Module> modules;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "specialityId", referencedColumnName = "id")
    private Speciality speciality;
}

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
@Table(name ="modules")
public class Module  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String name_module;

   // private String name_subject;
    private int coefficient;
    private  int nb_semester;
    private int credit;
    @JsonIgnore
    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Professor> professor;
}

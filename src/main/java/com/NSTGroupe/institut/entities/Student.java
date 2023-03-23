package com.NSTGroupe.institut.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@ToString
@Data

public class Student extends User {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
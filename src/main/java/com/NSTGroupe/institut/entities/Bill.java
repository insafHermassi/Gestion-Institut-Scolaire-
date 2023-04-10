package com.NSTGroupe.institut.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Bill")

public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBill", unique = true, nullable = false)
        private Long idBill;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "supplier_id_supplier")
        private Supplier supplier;

    @Column(name = "Number_Facture", length = 45)
        private int numberBill;
    @Column(name = "Product", length = 45)
        private String product;

    @Column(name = "number_Product", length = 45)
        private float numberProduct;

    @Column(name = "PriceHT", length = 45)
        private float priceHT ;

    @Column(name = "total_HT", length = 45)
        private float  totalHT;

    @Column(name = "active", length = 45)
        private boolean actif;
    @Column(name = "Date", length = 45)
        private Date date;


}

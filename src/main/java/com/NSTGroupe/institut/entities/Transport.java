package com.NSTGroupe.institut.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

    @Data
    @Entity
    @Table(name = "transport")
    public class
    Transport {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "idTransport", unique = true, nullable = false)
        private int idTransport;

        @ManyToOne
        @JoinColumn(name = "driver_id_person")
        private Driver driver;

        @Column(name = "dateDebut", columnDefinition="DATETIME")
        private Date dateDebut;

        @Column(name = "dateFin", columnDefinition="DATETIME")
        private Date dateFin;
        @ManyToOne
        @JoinColumn(name = "vehicle_id_vehicle")
        private Vehicle vehicle;
        @Column(name = "active", length = 45)
        private boolean active;




	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paiement_idPaiement", nullable = false)
	public Paiement getPaiement() {
		return this.paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Tarifs> getTarifses() {
		return this.tarifses;
	}

	public void setTarifses(Set<Tarifs> tarifses) {
		this.tarifses = tarifses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Horaire> getHoraires() {
		return this.horaires;
	}

	public void setHoraires(Set<Horaire> horaires) {
		this.horaires = horaires;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Positiongps> getPositiongpses() {
		return this.positiongpses;
	}

	public void setPositiongpses(Set<Positiongps> positiongpses) {
		this.positiongpses = positiongpses;
	}*/


//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
//	public Set<Eleve> getEleves() {
//		return eleves;
//	}
//
//	public void setEleves(Set<Eleve> eleves) {
//		this.eleves = eleves;
//	}
//


}

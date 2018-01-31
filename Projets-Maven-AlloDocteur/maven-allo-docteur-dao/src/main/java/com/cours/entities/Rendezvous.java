/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author badredine
 */
@Entity
@Table(name = "rendezvous")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rendezvous.findAll", query = "SELECT r FROM Rendezvous r"),
    @NamedQuery(name = "Rendezvous.findByIdRendezVous", query = "SELECT r FROM Rendezvous r WHERE r.idRendezVous = :idRendezVous"),
    @NamedQuery(name = "Rendezvous.findByJour", query = "SELECT r FROM Rendezvous r WHERE r.jour = :jour"),
    @NamedQuery(name = "Rendezvous.findByPrixConsultation", query = "SELECT r FROM Rendezvous r WHERE r.prixConsultation = :prixConsultation"),
    @NamedQuery(name = "Rendezvous.findByPresent", query = "SELECT r FROM Rendezvous r WHERE r.present = :present"),
    @NamedQuery(name = "Rendezvous.findByVersion", query = "SELECT r FROM Rendezvous r WHERE r.version = :version")})
public class Rendezvous implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRendezVous")
    private Integer idRendezVous;
    @Basic(optional = false)
    @Column(name = "jour")
    @Temporal(TemporalType.DATE)
    private Date jour;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixConsultation")
    private Double prixConsultation;
    @Column(name = "present")
    private Boolean present;
    @Column(name = "version")
    @Version
    private Integer version;
    @JoinColumn(name = "idCreneau", referencedColumnName = "idCreneau")
    @ManyToOne(optional = false)
    private Creneau idCreneau;
    @JoinColumn(name = "idPatient", referencedColumnName = "idPatient")
    @ManyToOne(optional = false)
    private Patient idPatient;

    public Rendezvous() {
    }

    public Rendezvous(Integer idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public Rendezvous(Integer idRendezVous, Date jour) {
        this.idRendezVous = idRendezVous;
        this.jour = jour;
    }
    
    public Rendezvous( Integer idRendezVous, Date jour, Double prixConsultation, Boolean present, Creneau idCreneau, Patient idPatient ) {
        this.idRendezVous = idRendezVous;
        this.jour = jour;
        this.prixConsultation = prixConsultation;
        this.present = present;
        this.idCreneau = idCreneau;
        this.idPatient = idPatient;
    }
    
    public Rendezvous( Date jour, Double prixConsultation, Boolean present, Creneau idCreneau, Patient idPatient ) {
        this.jour = jour;
        this.prixConsultation = prixConsultation;
        this.present = present;
        this.idCreneau = idCreneau;
        this.idPatient = idPatient;
    }

    public Integer getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(Integer idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Double getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(Double prixConsultation) {
        this.prixConsultation = prixConsultation;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Creneau getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(Creneau idCreneau) {
        this.idCreneau = idCreneau;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRendezVous != null ? idRendezVous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rendezvous)) {
            return false;
        }
        Rendezvous other = (Rendezvous) object;
        if ((this.idRendezVous == null && other.idRendezVous != null) || (this.idRendezVous != null && !this.idRendezVous.equals(other.idRendezVous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[idRendezVous=%s, jour=%s, prixConsultation=%s, present=%s, idCreneau=%s, idPatient=%s]",
            idRendezVous, jour, prixConsultation, present, idCreneau, idPatient );
    }
}

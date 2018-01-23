/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.maven.allo.docteur.dao.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author badredine
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdPatient", query = "SELECT p FROM Patient p WHERE p.idPatient = :idPatient"),
    @NamedQuery(name = "Patient.findByNumeroSecuriteSociale", query = "SELECT p FROM Patient p WHERE p.numeroSecuriteSociale = :numeroSecuriteSociale"),
    @NamedQuery(name = "Patient.findByNumeroTelephone", query = "SELECT p FROM Patient p WHERE p.numeroTelephone = :numeroTelephone"),
    @NamedQuery(name = "Patient.findByVersion", query = "SELECT p FROM Patient p WHERE p.version = :version")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatient")
    private Integer idPatient;
    @Column(name = "numeroSecuriteSociale")
    private String numeroSecuriteSociale;
    @Column(name = "numeroTelephone")
    private String numeroTelephone;
    @Column(name = "version")
    @Version
    private Integer version;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne(optional = false)
    private Integer idUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatient")
    private List<Rendezvous> rendezvousList;

    public Patient() {
    }

    public Patient(Integer idPatient) {
        this.idPatient = idPatient;
    }
    
    public Patient( Integer idPatient, String numeroSecuriteSociale, String numeroTelephone, Integer idUtilisateur, List<Rendezvous> rendezvousList) {
        this.idPatient = idPatient;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.numeroTelephone = numeroTelephone;
        this.idUtilisateur = idUtilisateur;
        this.rendezvousList = rendezvousList;
    }
    
    public Patient( Integer idUtilisateur, String numeroSecuriteSociale, String numeroTelephone, List<Rendezvous> rendezvousList) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.numeroTelephone = numeroTelephone;
        this.idUtilisateur = idUtilisateur;
        this.rendezvousList = rendezvousList;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @XmlTransient
    public List<Rendezvous> getRendezvousList() {
        return rendezvousList;
    }

    public void setRendezvousList(List<Rendezvous> rendezvousList) {
        this.rendezvousList = rendezvousList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[idPatient=%s, numeroSecuriteSociale=%s, numeroTelephone=%s, idUtilisateur=%s]",
        idPatient, numeroSecuriteSociale, numeroTelephone, idUtilisateur); 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.maven.allo.docteur.dao.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
 * @author badre
 */
@Entity
@Table(name = "creneau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creneau.findAll", query = "SELECT c FROM Creneau c"),
    @NamedQuery(name = "Creneau.findByIdCreneau", query = "SELECT c FROM Creneau c WHERE c.idCreneau = :idCreneau"),
    @NamedQuery(name = "Creneau.findByHeureDebut", query = "SELECT c FROM Creneau c WHERE c.heureDebut = :heureDebut"),
    @NamedQuery(name = "Creneau.findByMinuteDebut", query = "SELECT c FROM Creneau c WHERE c.minuteDebut = :minuteDebut"),
    @NamedQuery(name = "Creneau.findByHeureFin", query = "SELECT c FROM Creneau c WHERE c.heureFin = :heureFin"),
    @NamedQuery(name = "Creneau.findByMinuteFin", query = "SELECT c FROM Creneau c WHERE c.minuteFin = :minuteFin"),
    @NamedQuery(name = "Creneau.findByVersion", query = "SELECT c FROM Creneau c WHERE c.version = :version")})
public class Creneau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCreneau")
    private Integer idCreneau;
    @Column(name = "heureDebut")
    private Integer heureDebut;
    @Column(name = "minuteDebut")
    private Integer minuteDebut;
    @Column(name = "heureFin")
    private Integer heureFin;
    @Column(name = "minuteFin")
    private Integer minuteFin;
    @Column(name = "version")
    @Version
    private Integer version;
    @JoinColumn(name = "idMedecin", referencedColumnName = "idMedecin")
    @ManyToOne(optional = false)
    private Integer idMedecin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreneau")
    private List<Rendezvous> rendezvousList;

    public Creneau() {
    }

    public Creneau(Integer idCreneau) {
        this.idCreneau = idCreneau;
    }
    
    public Creneau( Integer idCreneau, Integer heureDebut, Integer minuteDebut, Integer heureFin, Integer minuteFin, Boolean principale, Integer idMedecin, List<Rendezvous> rendezvousList) {
        this.idCreneau = idCreneau;
        this.heureDebut = heureDebut;
        this.minuteDebut = minuteDebut;
        this.heureFin = heureFin;
        this.minuteFin = minuteFin;
        this.idMedecin = idMedecin;
        this.rendezvousList = rendezvousList;
    }
    
    public Creneau( Integer heureDebut, Integer minuteDebut, Integer heureFin, Integer minuteFin, Boolean principale, Integer idMedecin, List<Rendezvous> rendezvousList) {
        this.heureDebut = heureDebut;
        this.minuteDebut = minuteDebut;
        this.heureFin = heureFin;
        this.minuteFin = minuteFin;
        this.idMedecin = idMedecin;
        this.rendezvousList = rendezvousList;
    }
    
    public Integer getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(Integer idCreneau) {
        this.idCreneau = idCreneau;
    }

    public Integer getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Integer heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Integer getMinuteDebut() {
        return minuteDebut;
    }

    public void setMinuteDebut(Integer minuteDebut) {
        this.minuteDebut = minuteDebut;
    }

    public Integer getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Integer heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getMinuteFin() {
        return minuteFin;
    }

    public void setMinuteFin(Integer minuteFin) {
        this.minuteFin = minuteFin;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
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
        hash += (idCreneau != null ? idCreneau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creneau)) {
            return false;
        }
        Creneau other = (Creneau) object;
        if ((this.idCreneau == null && other.idCreneau != null) || (this.idCreneau != null && !this.idCreneau.equals(other.idCreneau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[idCreneau=%s, heureDebut=%s, minuteDebut=%s, heureFin=%s, minuteFin=%s, idMedecin=%s]",
            idCreneau, heureDebut, minuteDebut, heureFin, minuteFin, idMedecin );
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.IRendezVousDao;
import com.cours.entities.Rendezvous;
import com.cours.exception.CustomException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author badre
 */
@Repository
@Transactional
public class RendezVousDao implements IRendezVousDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Rendezvous> findAll() {
        
        String methodName = "RendezVousDao :: findAll";
        
        List<Rendezvous> ListeRendezvous = null;
        
        try {
            TypedQuery<Rendezvous> query = this.em.createNamedQuery("Patient.findAll", Rendezvous.class );
            ListeRendezvous = query.getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_RENDEZVOUS );
        }
        return ListeRendezvous;
    }

    @Override
    public Rendezvous findByIdRendezVous(Integer idRendezvous) {

        String methodName = "RendezVousDao :: findByIdRendezVous";
        
        Rendezvous rendezvous = null;
        
        try {
            TypedQuery<Rendezvous> query = this.em.createNamedQuery("Patient.findByIdRendezVous", Rendezvous.class );
            rendezvous = query.setParameter("idRendezvous", idRendezvous).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_RENDEZVOUS );
        }
        return rendezvous;
    }

    @Override
    public List<Rendezvous> findByJour(Date jour) {

        String methodName = "RendezVousDao :: findByJour";
        
        List<Rendezvous> ListeRendezvous = null;
        
        try {
            TypedQuery<Rendezvous> query = this.em.createNamedQuery("Patient.findByJour", Rendezvous.class );
            ListeRendezvous = query.setParameter("jour", jour).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_RENDEZVOUS );
        }
        return ListeRendezvous;
    }

    @Override
    public List<Rendezvous> findByPrixConsultation(Double prixConsultation) {

        String methodName = "RendezVousDao :: findByPrixConsultation";
        
        List<Rendezvous> ListeRendezvous = null;
        
        try {
            TypedQuery<Rendezvous> query = this.em.createNamedQuery("Patient.findByPrixConsultation", Rendezvous.class );
            ListeRendezvous = query.setParameter("prixConsultation", prixConsultation).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_RENDEZVOUS );
        }
        return ListeRendezvous;
    }

    @Override
    public List<Rendezvous> findByPresent(Boolean present) {
        
        String methodName = "RendezVousDao :: findByPresent";
        
        List<Rendezvous> ListeRendezvous = null;
        
        try {
            TypedQuery<Rendezvous> query = this.em.createNamedQuery("Patient.findByPresent", Rendezvous.class );
            ListeRendezvous = query.setParameter("present", present).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_RENDEZVOUS );
        }
        return ListeRendezvous;
    }

    @Override
    public Rendezvous createRendezvous(Rendezvous rendezvous) {

        String methodName = "RendezvousDao :: createRendezvous";
        
        try {
            this.em.persist(rendezvous);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return rendezvous;
    }

    @Override
    public Rendezvous updateRendezvous(Rendezvous rendezvous) {

        String methodName = "RendezvousDao :: updateRendezvous";
        
        try {
            this.em.merge(rendezvous);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return rendezvous;
    }

    @Override
    public Boolean deleteRendezvous(Rendezvous rendezvous) {
        
        String methodName = "RendezvousDao :: deleteRendezvous";
        
        try {
            this.em.remove(this.em.merge(rendezvous));
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return true;
    }
    
}

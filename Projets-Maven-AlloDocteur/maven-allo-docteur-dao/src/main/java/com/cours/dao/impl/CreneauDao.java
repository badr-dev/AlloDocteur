/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.ICreneauDao;
import com.cours.entities.Creneau;
import com.cours.exception.CustomException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author badredine
 */
@Repository
@Transactional
public class CreneauDao implements ICreneauDao {
    
    @PersistenceContext
    private EntityManager em; 

    @Override
    public List<Creneau> findAll() {
        String methodName = "CreneauDao :: FindAll";
        
        try {
            return this.em.createNamedQuery("Utilisateur.findAll", Creneau.class ).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public Creneau findByIdCreneau(Integer idCreneau) {
        String methodName = "CreneauDao :: findById";
        
        try {
            return this.em.createNamedQuery("Creneau.findById", Creneau.class ).setParameter("idCreneau", idCreneau).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public List<Creneau> findByHeureDebut(Integer heureDebut) {
        String methodName = "CreneauDao :: FindByHeureDebut";
        
        try {
            return this.em.createNamedQuery("Creneau.findByHeureDebut", Creneau.class ).setParameter("heureDebut", heureDebut).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public List<Creneau> findByMinuteDebut(Integer minuteDebut) {
        String methodName = "CreneauDao :: FindByMinuteDebut";
        
        try {
            return this.em.createNamedQuery("Creneau.findByMinuteDebut", Creneau.class ).setParameter("minuteDebut", minuteDebut).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public List<Creneau> findByHeureFin(Integer heureFin) {
        String methodName = "CreneauDao :: FindByHeureFin";
        
        try {
            return this.em.createNamedQuery("Creneau.findByHeureFin", Creneau.class ).setParameter("heureFin", heureFin).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public List<Creneau> findByMinuteFin(Integer minuteFin) {
        String methodName = "CreneauDao :: FindByMinuteFin";
        
        try {
            return this.em.createNamedQuery("Creneau.findByMinuteFin", Creneau.class ).setParameter("minuteFin", minuteFin).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
    }

    @Override
    public Creneau createCreneau(Creneau creneau) {
        String methodName = "CreneauDao :: createCreneau";
        
        try {
            this.em.persist(creneau);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return creneau;
    }

    @Override
    public Creneau updateCreneau(Creneau creneau) {
        
        String methodName = "CreneauDao :: updateCreneau";
        
        try {
            this.em.merge(creneau);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return creneau;
    }

    @Override
    public Boolean deleteCreneau(Creneau creneau) {
        String methodName = "CreneauxDao :: deleteCreneaux";
        
        try {
            this.em.remove( this.em.merge(creneau) );
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_CRENEAUX );
        }
        return true;
    }
}

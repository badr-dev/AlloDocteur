/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.IMedecinDao;
import com.cours.entities.Adresse;
import com.cours.entities.Medecin;
import com.cours.exception.CustomException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author badredine
 */
@Repository("medecinDao")
@Transactional
public class MedecinDao implements IMedecinDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override 
    public List<Medecin> findAll() {
        
        String methodName = "MedecinDao :: findAll";
        
        List<Medecin> ListeMedecin = null;
        
        try {
            TypedQuery<Medecin> query = this.em.createNamedQuery("Medecin.findAll", Medecin.class );
            ListeMedecin = query.getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return ListeMedecin;
    }

    @Override
    public Medecin findByIdMedecin(Integer idMedecin) {

        String methodName = "MedecinDao :: findByIdMedecin";
        
        Medecin medecin = null;
        
        try {
            TypedQuery<Medecin> query = this.em.createNamedQuery("Medecin.findByIdMedecin", Medecin.class );
            medecin = query.setParameter("idMedecin", idMedecin).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }
    
    @Override
    public Medecin findByIdUtilisateur(Integer IdUtilisateur) {

        String methodName = "MedecinDao :: findByIdUtilisateur";
        
        Medecin medecin = null;
        
        try {
            TypedQuery<Medecin> query = this.em.createNamedQuery("Medecin.findByIdUtilisateur", Medecin.class );
            medecin = query.setParameter("IdUtilisateur", IdUtilisateur).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }

    @Override
    public Medecin findByNumeroAccreditation(String numeroAccreditation) {
        
        String methodName = "MedecinDao :: findByNumeroAccreditation";
        
        Medecin medecin = null;
        
        try {
            TypedQuery<Medecin> query = this.em.createNamedQuery("Medecin.findByNumeroAccreditation", Medecin.class );
            medecin = query.setParameter("numeroAccreditation", numeroAccreditation).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }

    @Override
    public Medecin findByNumeroTelephone(String numeroTelephone) {
        
        String methodName = "MedecinDao :: findByNumeroTelephone";
        
        Medecin medecin = null;
        
        try {
            TypedQuery<Medecin> query = this.em.createNamedQuery("Medecin.findByNumeroTelephone", Medecin.class );
            medecin = query.setParameter("numeroTelephone", numeroTelephone).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }

    @Override
    public Medecin CreateMedecin(Medecin medecin) {
        String methodName = "MedecinDao :: CreateMedecin";
        
        try {
            this.em.persist(medecin);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }

    @Override
    public Medecin UpdateMedecin(Medecin medecin) {
        String methodName = "MedecinDao :: UpdateMedecin";
        
        try {
            this.em.merge(medecin);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return medecin;
    }

    @Override
    public Boolean DeleteMedecin(Medecin medecin) {

        String methodName = "MedecinDao :: DeleteMedecin";
        
        try {
            this.em.remove( this.em.merge(medecin) );
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_MEDECINS );
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.IAdresseDao;
import com.cours.entities.Adresse;
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
@Repository
@Transactional
public class AdresseDao implements IAdresseDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Adresse> findAll() {
        String methodName = "AdresseDao :: FindAll";
        
        List<Adresse> ListeAdresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findAll", Adresse.class );
            ListeAdresse = query.getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return ListeAdresse; 
    }

    @Override
    public Adresse findByIdAdresse(Integer IdAdresse) {

        String methodName = "AdresseDao :: findByIdAdresse";
        
        Adresse adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByIdAdresse", Adresse.class );
            adresse = query.setParameter("idAdresse", IdAdresse).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public Adresse findByRue(String Rue) {
        String methodName = "AdresseDao :: findByRue";
        
        Adresse adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByRue", Adresse.class );
            adresse = query.setParameter("rue", Rue).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public List<Adresse> findByCodePostal(String CodePostal) {
        String methodName = "AdresseDao :: findByCodePostal";
        
        List<Adresse> adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByCodePostal", Adresse.class );
            adresse = query.setParameter("codePostal", CodePostal).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public List<Adresse> findByVille(String Ville) {
        String methodName = "AdresseDao :: findByVille";
        
        List<Adresse> adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByVille", Adresse.class );
            adresse = query.setParameter("ville", Ville).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public List<Adresse> findByPays(String Pays) {
        String methodName = "AdresseDao :: findByPays";
        
        List<Adresse> adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByPays", Adresse.class );
            adresse = query.setParameter("CodePostal", Pays).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public List<Adresse> findByPrincipale(Boolean Principale) {
        String methodName = "AdresseDao :: findByPrincipale";
        
        List<Adresse> adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByPrincipale", Adresse.class );
            adresse = query.setParameter("principale", Principale).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public List<Adresse> findByVersion(Integer Version) {
        String methodName = "AdresseDao :: findByVersion";
        
        List<Adresse> adresse = null;
        
        try {
            TypedQuery<Adresse> query = this.em.createNamedQuery("Adresse.findByVersion", Adresse.class );
            adresse = query.setParameter("version", Version).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
        String methodName = "AdresseDao :: createAdresse";
        
        try {
            this.em.persist(adresse);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
        String methodName = "AdresseDao :: updateAdresse";
        
        try {
            this.em.merge(adresse);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return adresse;
    }

    @Override
    public Boolean deleteAdresse(Adresse adresse) {
        String methodName = "AdresseDao :: deleteAdresse";
        
        try {
            this.em.remove( this.em.merge(adresse) );
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_ADRESSES );
        }
        return true;
    }
}

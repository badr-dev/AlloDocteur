/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.IUtilisateurDao;
import com.cours.entities.Utilisateur;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional; 

import com.cours.exception.CustomException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author badredine
 */
@Repository
@Transactional
public class UtilisateurDao implements IUtilisateurDao {

    @PersistenceContext
    private EntityManager em; 

    
    @Override
    public List<Utilisateur> findAll() {
        String methodName = "UtilisateurDao :: FindAll";
        
        List<Utilisateur> ListeUtilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findAll", Utilisateur.class );
            ListeUtilisateur = query.getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return ListeUtilisateur; 
    }

    @Override
    public Utilisateur findById(Integer idUtilisateur) {
    
        String methodName = "UtilisateurDao :: findById";
        
        Utilisateur utilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findById", Utilisateur.class );
            utilisateur = query.setParameter("idUtilisateur", idUtilisateur).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return utilisateur; 
    }

    @Override
    public List<Utilisateur> findByCivilite(String civilite) {
        String methodName = "UtilisateurDao :: findByCivilite";
        
        List<Utilisateur> ListeUtilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findByCivilite", Utilisateur.class );
            ListeUtilisateur = query.setParameter("civilite", civilite).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return ListeUtilisateur; 
    }

    @Override
    public List<Utilisateur> findByPrenom(String prenom) {
    
        String methodName = "UtilisateurDao :: findByPrenom";
        
        List<Utilisateur> ListeUtilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findByPrenom", Utilisateur.class );
            ListeUtilisateur = query.setParameter("prenom", prenom).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return ListeUtilisateur;
    }

    @Override
    public List<Utilisateur> findByNom(String nom) {
        String methodName = "UtilisateurDao :: findByPrenom";
        
        List<Utilisateur> ListeUtilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findByNom", Utilisateur.class );
            ListeUtilisateur = query.setParameter("nom", nom).getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return ListeUtilisateur;
    }

    @Override
    public Utilisateur findByIdentifiant(String identifiant) {
    
        String methodName = "UtilisateurDao :: findByIdentifiant";
        
        Utilisateur utilisateur = null;
        
        try {
            TypedQuery<Utilisateur> query = this.em.createNamedQuery("Utilisateur.findByIdentifiant", Utilisateur.class );
            utilisateur = query.setParameter("identifiant", identifiant).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return utilisateur;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        
        String methodName = "UtilisateurDao :: createUtilisateur";
        
        try {
            this.em.persist(utilisateur);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return utilisateur;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        
        String methodName = "UtilisateurDao :: updateUtilisateur";
        
        try {
            this.em.merge(utilisateur);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return utilisateur;
    }

    @Override
    public Boolean deleteUtilisateur(Utilisateur utilisateur) {
        
        String methodName = "UtilisateurDao :: deleteUtilisateur";
        
        boolean isOk = true; 
        
        try {
            this.em.remove( this.em.merge(utilisateur) );
        } catch (Exception e) {
            isOk = false; 
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_UTILISATEURS );
        }
        return isOk;
    }
}

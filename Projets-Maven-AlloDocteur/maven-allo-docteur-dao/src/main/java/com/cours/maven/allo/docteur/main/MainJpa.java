/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.maven.allo.docteur.main;

import com.cours.maven.allo.docteur.dao.entities.Utilisateur;
import com.cours.maven.allo.docteur.dao.entities.Medecin;
import com.cours.maven.allo.docteur.dao.entities.Patient;
import com.cours.maven.allo.docteur.dao.entities.Adresse;
import com.cours.maven.allo.docteur.dao.entities.Creneau;
import com.cours.maven.allo.docteur.dao.entities.Rendezvous;

import com.cours.exception.CustomException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 


/**
 *
 * @author badredine
 */
public class MainJpa {
    
    private static final String persistenceUnit = "BaseAlloDocteur";
    
    public static void main(String[] args) {
        String methodName = "main";
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();
        
        System.out.println("AVANT BEGIN TRANSACTION");
        em.getTransaction().begin();
        System.out.println("APRES BEGIN TRANSACTION");
        em.getTransaction().commit();
        System.out.println("APRES COMMIT TRANSACTION");
        // libération ressources
        em.close();
        emf.close();
        System.out.println("APRES LES CLOSES");
    }
}

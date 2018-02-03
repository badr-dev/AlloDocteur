/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.service.impl;

import com.cours.dao.impl.UtilisateurDao;
import com.cours.entities.Utilisateur;
import com.cours.service.IUtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author badredine
 */
@Service
@Transactional
public class UtilisateurService implements IUtilisateurService{

    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Override
    @Transactional
    public List<Utilisateur> findAll() {
        return this.utilisateurDao.findAll();
    }

    @Override
    @Transactional
    public Utilisateur findById(Integer idUtilisateur) {
        return this.utilisateurDao.findById(idUtilisateur);
    }

    @Override
    @Transactional
    public List<Utilisateur> findByCivilite(String civilite) {
        return this.utilisateurDao.findByCivilite(civilite);
    }

    @Override
    @Transactional
    public List<Utilisateur> findByPrenom(String prenom) {
        return this.utilisateurDao.findByPrenom(prenom);
    }

    @Override
    @Transactional
    public List<Utilisateur> findByNom(String nom) {
        return this.utilisateurDao.findByNom(nom);
    }

    @Override
    @Transactional
    public Utilisateur findByIdentifiant(String identifiant) {
        return this.utilisateurDao.findByIdentifiant(identifiant);
    }

    @Override
    @Transactional
    public Utilisateur createUtilisateur(Utilisateur Utilisateur) {
        return this.utilisateurDao.createUtilisateur(Utilisateur);
    }

    @Override
    @Transactional
    public Utilisateur updateUtilisateur(Utilisateur Utilisateur) {
        return this.utilisateurDao.createUtilisateur(Utilisateur);
    }

    @Override
    @Transactional
    public Boolean deleteUtilisateur(Utilisateur Utilisateur) {
        return this.utilisateurDao.deleteUtilisateur(Utilisateur);
    }
    
}

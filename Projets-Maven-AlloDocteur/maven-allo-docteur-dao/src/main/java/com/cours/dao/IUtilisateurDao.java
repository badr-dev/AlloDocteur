/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Utilisateur;

import java.util.List;

/**
 *
 * @author badredine
 */
public interface IUtilisateurDao {
    
    public List<Utilisateur> findAll();

    public Utilisateur findById( Integer idUtilisateur );

    public List<Utilisateur> findByCivilite( String civilite );
    
    public List<Utilisateur> findByPrenom( String prenom );

    public List<Utilisateur> findByNom( String nom );

    public Utilisateur findByIdentifiant( String identifiant );
    
    public Utilisateur createUtilisateur( Utilisateur Utilisateur );

    public Utilisateur updateUtilisateur( Utilisateur Utilisateur );

    public Boolean deleteUtilisateur( Utilisateur Utilisateur );
    
}

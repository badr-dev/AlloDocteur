/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Adresse;
import java.util.List;

/**
 *
 * @author badredine
 */
public interface IAdresseDao {
    
        public List<Adresse> findAll();
    
    public Adresse findByIdAdresse( Integer idAdresse );
    
    public Adresse findByRue( String rue );
    
    public List<Adresse> findByCodePostal( String codePostal );
    
    public List<Adresse> findByVille( String ville );
    
    public List<Adresse> findByPays( String pays );
    
    public List<Adresse> findByPrincipale( Boolean principale );
    
    public Adresse createAdresse( Adresse adresse );
    
    public Adresse updateAdresse( Adresse adresse );
    
    public Boolean deleteAdresse( Adresse adresse );
}
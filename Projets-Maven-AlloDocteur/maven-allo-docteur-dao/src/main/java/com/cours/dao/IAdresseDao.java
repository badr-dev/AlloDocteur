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
    
    public Adresse findByIdAdresse( Integer IdAdresse );
    
    public Adresse findByRue( String Rue );
    
    public List<Adresse> findByCodePostal( String CodePostal );
    
    public List<Adresse> findByVille( String Ville );
    
    public List<Adresse> findByPays( String Pays );
    
    public List<Adresse> findByPrincipale( Boolean Principale );
    
    public List<Adresse> findByVersion( Integer Version );
    
    public Adresse createAdresse( Adresse Adresse );
    
    public Adresse updateAdresse( Adresse Adresse );
    
    public Boolean deleteAdresse( Adresse Adresse );
}
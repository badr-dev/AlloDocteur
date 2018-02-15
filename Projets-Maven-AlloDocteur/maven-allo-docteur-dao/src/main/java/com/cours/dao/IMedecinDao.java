/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Medecin;
import java.util.List;

/**
 *
 * @author badredine
 */
public interface IMedecinDao {
    
    public List<Medecin> findAll();
    
    public Medecin findByIdMedecin( Integer idMedecin );
    
    public Medecin findByIdUtilisateur( Integer idUtilisateur );
    
    public Medecin findByNumeroAccreditation( String numeroAccreditation );
    
    public Medecin findByNumeroTelephone( String numeroTelephone );
    
    public Medecin CreateMedecin( Medecin medecin);
    
    public Medecin UpdateMedecin( Medecin medecin);
    
    public Boolean DeleteMedecin( Medecin medecin);
}
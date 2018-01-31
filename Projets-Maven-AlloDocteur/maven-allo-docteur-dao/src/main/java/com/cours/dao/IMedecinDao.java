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
    
    public List<Medecin> findAllMedecins();
    
    public Medecin findByIdMedecin( Integer idMedecin );
    
    public Medecin findByNumeroAccreditation( String numeroAccreditation );
    
    public Medecin findByNumeroTelephone( String numeroTelephone );
    
    public Medecin CreateMedecin( Medecin Medecin);
    
    public Medecin UpdateMedecin( Medecin Medecin);
    
    public Boolean DeleteMedecin( Medecin Medecin);
}
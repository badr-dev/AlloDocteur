/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Patient;
import java.util.List;

/**
 *
 * @author badredine
 */
public interface IPatientDao {
    
    public List<Patient> findAll();
    
    public Patient findByIdPatient( Integer idPatient );
    
    public Patient findByIdUtilisateur( Integer idUtilisateur );
    
    public Patient findByNumeroSecuriteSociale( String NumeroSecuriteSociale );
    
    public Patient findByNumeroTelephone( String NumeroTelephone );
    
    public Patient createPatient( Patient Patient );
    
    public Patient updatePatient( Patient Patient );
    
    public Boolean deletePatient( Patient Patient );
}
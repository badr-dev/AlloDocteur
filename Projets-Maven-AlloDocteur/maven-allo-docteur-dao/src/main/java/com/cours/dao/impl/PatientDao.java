/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl;

import com.cours.dao.IPatientDao;
import com.cours.entities.Patient;
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
@Repository("patientDao")
@Transactional
public class PatientDao implements IPatientDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Patient> findAll() {

        String methodName = "PatientDao :: findAll";
        
        List<Patient> ListePatient = null;
        
        try {
            TypedQuery<Patient> query = this.em.createNamedQuery("Patient.findAll", Patient.class );
            ListePatient = query.getResultList();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return ListePatient;
    }

    @Override
    public Patient findByIdPatient(Integer idPatient) {

        String methodName = "PatientDao :: findByIdMedecin";
        
        Patient patient = null;
        
        try {
            TypedQuery<Patient> query = this.em.createNamedQuery("Patient.findByIdMedecin", Patient.class );
            patient =  query.setParameter("idPatient", idPatient).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }
    
    @Override
    public Patient findByIdUtilisateur(Integer idUtilisateur) {

        String methodName = "PatientDao :: findByidUtilisateur";
        
        Patient patient = null;
        
        try {
            TypedQuery<Patient> query = this.em.createNamedQuery("Patient.findByidUtilisateur", Patient.class );
            patient =  query.setParameter("idPatient", idUtilisateur).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }

    @Override
    public Patient findByNumeroSecuriteSociale(String numeroSecuriteSociale) {
        
        String methodName = "PatientDao :: findByNumeroSecuriteSociale";
        
        Patient patient = null;
        
        try {
            TypedQuery<Patient> query = this.em.createNamedQuery("Patient.findByNumeroSecuriteSociale", Patient.class );
            patient =  query.setParameter("numeroSecuriteSociale", numeroSecuriteSociale).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }

    @Override
    public Patient findByNumeroTelephone(String numeroTelephone) {

        String methodName = "PatientDao :: findByNumeroTelephone";
        
        Patient patient = null;
        
        try {
            TypedQuery<Patient> query = this.em.createNamedQuery("Patient.findByNumeroTelephone", Patient.class );
            patient =  query.setParameter("numeroTelephone", numeroTelephone).getSingleResult();
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }

    @Override
    public Patient createPatient(Patient patient) {

        String methodName = "PatientDao :: createPatient";
        
        try {
            this.em.persist(patient);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {

        String methodName = "PatientDao :: updatePatient";
        
        try {
            this.em.merge(patient);
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return patient;
    }

    @Override
    public Boolean deletePatient(Patient patient) {

        String methodName = "Patient :: deletePatient";
        
        try {
            this.em.remove( this.em.merge(patient) );
        } catch (Exception e) {
            throw new CustomException(" ERROR IN => " + methodName, e, CustomException.ERROR_DAO_PATIENTS );
        }
        return true;
    }
    
}

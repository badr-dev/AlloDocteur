/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.service.impl;

import com.cours.dao.IAdresseDao;
import com.cours.dao.ICreneauDao;
import com.cours.dao.IMedecinDao;
import com.cours.dao.IPatientDao;
import com.cours.dao.IRendezVousDao;
import com.cours.dao.IUtilisateurDao;
import com.cours.service.IServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author badredine
 */
@Service("serviceFacade")
public class ServiceFacade implements IServiceFacade {

    private static final Log log = LogFactory.getLog(ServiceFacade.class);
    
    @Autowired
    private IUtilisateurDao utilisateurDao  = null;
    @Autowired
    private IMedecinDao     medecinDao      = null;
    @Autowired
    private IPatientDao     patientDao      = null;
    @Autowired
    private IAdresseDao     adresseDao      = null;
    @Autowired
    private ICreneauDao     creneauDao      = null;
    @Autowired
    private IRendezVousDao  rendezVousDao   = null;
    
    
    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }

    @Override
    public IAdresseDao getAdresseDao() {
        return adresseDao;
    }

    @Override
    public IMedecinDao getMedecinDao() {
        return medecinDao;
    }

    @Override
    public IPatientDao getPatientDao() {
        return patientDao;
    }

    @Override
    public ICreneauDao getCreneauDao() {
        return creneauDao;
    }

    @Override
    public IRendezVousDao getRendezVousDao() {
        return rendezVousDao;
    }
}

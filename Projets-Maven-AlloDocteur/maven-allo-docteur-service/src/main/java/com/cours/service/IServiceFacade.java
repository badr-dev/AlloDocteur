/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.service;

import com.cours.dao.IAdresseDao;
import com.cours.dao.ICreneauDao;
import com.cours.dao.IMedecinDao;
import com.cours.dao.IPatientDao;
import com.cours.dao.IRendezVousDao;
import com.cours.dao.IUtilisateurDao;

/**
 *
 * @author badredine
 */
public interface IServiceFacade {

    public IUtilisateurDao getUtilisateurDao();

    public IAdresseDao getAdresseDao();
    
    public IMedecinDao getMedecinDao();
    
    public IPatientDao getPatientDao();
    
    public ICreneauDao getCreneauDao();
    
    public IRendezVousDao getRendezVousDao();
}

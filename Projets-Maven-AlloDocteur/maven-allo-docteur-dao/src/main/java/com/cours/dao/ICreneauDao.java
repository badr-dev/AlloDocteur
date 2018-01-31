/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Creneau;
import java.util.List;

/**
 *
 * @author badredine
 */
public interface ICreneauDao {
    
    public List<Creneau> findAll();
    
    public Creneau findByIdCreneau( Integer IdCreneau );
    
    public List<Creneau> findByHeureDebut( Integer heureDebut );
    
    public List<Creneau> findByMinuteDebut( Integer minuteDebut );
    
    public List<Creneau> findByHeureFin( Integer heureFin );
    
    public List<Creneau> findByMinuteFin( Integer minuteFin );
    
    public List<Creneau> findByVersion( Integer version);
    
    public Creneau createCreneau( Creneau Creneau );
    
    public Creneau updateCreneau( Creneau Creneau );
    
    public Boolean deleteCreneau( Creneau Creneau );
 }

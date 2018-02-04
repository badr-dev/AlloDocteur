/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import com.cours.entities.Rendezvous;
import java.util.Date;
import java.util.List;

/**
 *
 * @author badredine
 */
public interface IRendezVousDao {
    
    public List<Rendezvous> findAll();
    
    public Rendezvous findByIdRendezVous( Integer idRendezvous );
    
    public List<Rendezvous> findByJour( Date jour );
    
    public List<Rendezvous> findByPrixConsultation( Double prixConsultation );
    
    public List<Rendezvous> findByPresent( Boolean present );
    
    public Rendezvous createRendezvous( Rendezvous rendezvous );
    
    public Rendezvous updateRendezvous( Rendezvous rendezvous );
    
    public Boolean deleteRendezvous( Rendezvous rendezvous );
    
}
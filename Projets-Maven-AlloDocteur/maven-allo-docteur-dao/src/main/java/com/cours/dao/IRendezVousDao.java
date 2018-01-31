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
    
    public Rendezvous findByIdRendezVous( Integer IdRendezvous );
    
    public List<Rendezvous> findByJour( Date Jour );
    
    public List<Rendezvous> findByPrixConsultation( Double PrixConsultation );
    
    public List<Rendezvous> findByPresent( Boolean Present );
    
    public List<Rendezvous> findByVersion( Integer Version );
    
    public Rendezvous createRendezvous( Rendezvous Rendezvous );
    
    public Rendezvous updateRendezvous( Rendezvous Rendezvous );
    
    public Boolean deleteRendezvous( Rendezvous Rendezvous );
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.service.impl;

import com.cours.dao.impl.AdresseDao;
import com.cours.entities.Adresse;
import com.cours.service.IAdresseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author badre
 */
public class AdresseService implements IAdresseService {
    
    @Autowired
    private AdresseDao adresseDao;

    @Override
    @Transactional
    public List<Adresse> findAll() {
        return this.adresseDao.findAll();
    }

    @Override
    @Transactional
    public Adresse findByIdAdresse(Integer idAdresse) {
        return this.adresseDao.findByIdAdresse(idAdresse);
    }

    @Override
    public Adresse findByRue(String rue) {
        return this.adresseDao.findByRue(rue);
    }

    @Override
    public List<Adresse> findByCodePostal(String codePostal) {
        return this.adresseDao.findByCodePostal(codePostal);
    }

    @Override
    public List<Adresse> findByVille(String ville) {
        return this.adresseDao.findByVille(ville);
    }

    @Override
    public List<Adresse> findByPays(String pays) {
        return this.adresseDao.findByPays(pays);
    }

    @Override
    public List<Adresse> findByPrincipale(Boolean principale) {
        return this.adresseDao.findByPrincipale(principale);
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
        return this.adresseDao.createAdresse(adresse);
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
        return this.adresseDao.updateAdresse(adresse);
    }

    @Override
    public Boolean deleteAdresse(Adresse adresse) {
        return this.adresseDao.deleteAdresse(adresse);
    }
    
}

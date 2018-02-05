package com.cours.service.impl;

import java.util.List;

import com.cours.dao.impl.RendezVousDao;
import com.cours.entities.Rendezvous;
import com.cours.service.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RendezVousService implements IRendezVousService {

	@Autowired
    private RendezVousDao rendezVousDao;
	
	@Override
	public List<Rendezvous> findAll() {
            return rendezVousDao.findAll();
	}

}

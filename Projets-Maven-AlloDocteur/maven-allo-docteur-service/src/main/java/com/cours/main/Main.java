/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.dao.IUtilisateurDao;
import com.cours.entities.Utilisateur;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author badre
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
    
        IUtilisateurDao utilisateurDao = (IUtilisateurDao) ctx.getBean("utilisateurDao");
        
        List<Utilisateur> listeUser = null;
        
        listeUser = utilisateurDao.findAll();
        
        System.out.println("Liste utilisateur :: " + listeUser);
        
        String toto = "toto";
    }
}

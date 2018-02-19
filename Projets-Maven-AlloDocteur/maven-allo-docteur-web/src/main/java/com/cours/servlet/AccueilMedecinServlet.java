/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.servlet;

import com.cours.entities.Creneau;
import com.cours.entities.Medecin;
import com.cours.entities.Rendezvous;
import com.cours.service.IServiceFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author badredine
 */
@WebServlet(name = "AccueilMedecinServlet", urlPatterns = {"/AccueilMedecinServlet"})
public class AccueilMedecinServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade service = null;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null || session.getAttribute("medecin") != null) {

            WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            this.service = (IServiceFacade) context.getBean("serviceFacade");

            Medecin medecin;
            medecin = (Medecin) session.getAttribute("medecin");

            List<Creneau> creneaux = medecin.getCreneauList();

            if (medecin != null) {

//                List<Creneau> creneaux = service.getCreneauDao().findByIdMedecin(medecin.getIdUtilisateur());
//
//                String yoyo = "yoyo";
//                
//                        List<Rendezvous> rdv = null;
//                        
//                        if (creneaux.size() > 0) {
//                            for( int i=0; i < creneaux.size(); i++) {
//                                
//                                
//                            }
//                        }
                
                
                this.getServletContext().getRequestDispatcher("/pages/medecin/medecin.jsp").forward(request, response);
            
            } else {
                this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
            }
        } else {
            this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

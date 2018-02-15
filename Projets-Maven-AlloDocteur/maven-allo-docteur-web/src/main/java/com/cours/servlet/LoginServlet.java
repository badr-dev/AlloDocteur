/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.servlet;

import com.cours.entities.Medecin;
import com.cours.entities.Patient;
import com.cours.entities.Utilisateur;
import com.cours.exception.CustomException;
import com.cours.service.IServiceFacade;
import com.cours.utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author elhad
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade service = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.service = (IServiceFacade) context.getBean("serviceFacade");
        log.debug("allAdresses: " + this.service.getAdresseDao().findAll());
        this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.service = (IServiceFacade) context.getBean("serviceFacade");

        Utilisateur utilisateur = null;

        JSONObject json = new JSONObject();

        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();

        utilisateur = this.service.getUtilisateurDao().findByIdentifiant(login);

        if (utilisateur != null) {

            Patient patient = null;
            Medecin medecin = null;

            patient = this.service.getPatientDao().findByIdUtilisateur(utilisateur.getIdUtilisateur());
            medecin = this.service.getMedecinDao().findByIdUtilisateur(utilisateur.getIdUtilisateur());

            HttpSession session = request.getSession();
            
            session.setAttribute(Constants.SESSION_UTILISATEUR, utilisateur);
            
            if (medecin != null) {
                
                try {
                    json.put("result", 1);
                    json.put("nextUrl", "AccueilMedecinServlet?utilisateurId=" + medecin.getIdUtilisateur());
                } catch (JSONException jse) {
                    throw new CustomException("Error medecin Json Object in :: LoginServlet", jse, CustomException.ERROR_LOGIN_SERVLET);
                }
                session.setAttribute(Constants.SESSION_MEDECIN, medecin);
                
            } else if (patient != null) {

                try {
                    json.put("result", 2);
                    json.put("nextUrl", "AccueilPatientServlet?utilisateurId=" + patient.getIdUtilisateur());
                } catch (JSONException jse) {
                    throw new CustomException("Error patient Json Object in :: LoginServlet", jse, CustomException.ERROR_LOGIN_SERVLET);
                }
                session.setAttribute(Constants.SESSION_PATIENT, patient);
                return;
            }
            else {
                session.setAttribute(Constants.SESSION_UTILISATEUR, null );
                return;
            }
            
        } else {

            try {
                json.put("result", -1);
                json.put("message", "Login ou mots de passe incorrect");
            } catch (JSONException jse) {
                throw new CustomException("Error user not found in :: LoginServlet", jse, CustomException.ERROR_LOGIN_SERVLET);
            }
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}

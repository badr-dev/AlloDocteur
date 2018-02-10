/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.servlet;

import com.cours.entities.Utilisateur;
import com.cours.service.IServiceFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author elhad
 */
// @WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade service = null;

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = (IServiceFacade) context.getBean("serviceFacade");
        log.debug("allAdresses: " + service.getAdresseDao().findAll());
        this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        
        String login    = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        	
        List<Utilisateur> utilisateur  = service.getUtilisateurDao().findAll();
        
        String reponse = "Hello " + login;

        response.setContentType("application/json");
        response.getWriter().write(reponse);
        
    }

}

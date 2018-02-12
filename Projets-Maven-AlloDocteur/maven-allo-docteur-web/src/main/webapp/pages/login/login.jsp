<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang=""> 
    <head>
        <meta charset="utf-8"> 
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Allo Docteur</title>
        <link rel="apple-touch-icon" href="/maven-allo-docteur-web/apple-touch-icon.png">
        <link rel="stylesheet" href="/maven-allo-docteur-web/styles/bootstrap.css"> 
        <link rel="stylesheet" href="/maven-allo-docteur-web/styles/main.css">
        <link rel="stylesheet" href="/maven-allo-docteur-web/styles/rwd.css">
        
        <link rel="stylesheet" href="/maven-allo-docteur-web/styles/sweetalert2.min.css">
        
    </head>
    <body class="clearfix">
        <!--[if IE]>
          <p class="browserupgrade">Vous utilisez un <strong>obsolète</strong> navigateur. Merci de se <a href="http://browsehappy.com/">mettre à jour</a> pour améliorer votre experience.</p>
        <![endif]-->
        <div class="container-fluid  no-padding">
            <div class="container-fluid clearfix no-padding header-container">
                <div class="container header-content">
                    <a href="#" class="logo">
                        <img src="/maven-allo-docteur-web/images/logo.png" alt="">
                    </a>
                    <ul class="loginMenu">
                        <li><a href="#">Création compte</a></li>
                        <li><a class="active" href="#">Connexion</a></li>
                    </ul>
                    <ul class="nav">
                        <li><a href="#">Patient</a></li>
                        <li><a href="#">Médecin</a></li>
                        <li><a href="#">Prendre rendez vous</a></li>
                        <li><a href="#">Informations médecins</a></li>
                        <li><a href="#">Informations patient</a></li>
                        <li><a href="#">Recherche patient</a></li>
                        <li><a href="#">Présence rendez-vous</a></li>
                        <li><a href="#">Selection créneau</a></li>
                    </ul>
                </div>
            </div>
            <div class="container-fluid clearfix">
                <div class="container content-outer connexion">
                    <div class="content-container connexion-container clearfix">
                        <div class="content">
                            <div class="righ-block">
                                <h3>SE CONNECTER</h3>
                                <form action="LoginServlet" id="form_login" class="login-form">
                                  <input type="text" name="login" placeholder="LOGIN">
                                  <input type="password" name="password" placeholder="PASSWORD">
                                  <button id="btn_send_form_login" type="submit">se connecter</button>
                                  <div class="clearfix"> </div>
                                  <a href="#" class="forgot-pass-link clearfix">Mot de passe oublié?</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/maven-allo-docteur-web/scripts/jquery.js"></script>
        <script src="/maven-allo-docteur-web/scripts/jquery.slicknav.js"></script>
        
        <script src="/maven-allo-docteur-web/scripts/jquery_validation/jquery.validate.min.js"></script>
        
        <script src="/maven-allo-docteur-web/scripts/sweetalert2.min.js"></script>
        
        <script src="/maven-allo-docteur-web/scripts/main.js"></script>
                
        <script src="/maven-allo-docteur-web/scripts/resource/login.js"></script>
        
    </body>
</html>

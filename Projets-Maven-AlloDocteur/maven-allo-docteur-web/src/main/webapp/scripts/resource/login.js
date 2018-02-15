/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Bloque le bouton d'envoi
function lockBtn(btn, loader) {

  loader = typeof loader !== 'undefined' ? loader : false;

  btn.each(function () {

    $(this).addClass('disabled');

    if ($(this).is('a, area, link, button, input, select, textarea, optgroup, option, fieldset')) {
      $(this).attr('disabled', 'disabled');
      $(this).prop('disabled', true);
    }

    if (loader) {
      $(this).attr('data-loading-text', $(this).html());
      $(this).html('<i class="material-icons">&#xE863;</i>');
    }
  });
}

// Débloque le bouton d'envoi
function unlockBtn(btn, loader) {

  loader = typeof loader !== 'undefined' ? loader : false;

  btn.each(function () {

    if (loader) {
      $(this).html($(this).data('loadingText'));
    }

    if ($(this).is('a, area, link, button, input, select, textarea, optgroup, option, fieldset')) {
      $(this).removeAttr('disabled');
      $(this).prop('disabled', false);
    }

    $(this).removeClass('disabled');
  });
}


$(document).ready(function () {

  // Connexion
  if ($('form#form_login').length > 0) {

    var formLogin = $('#form_login');
    var formLoginBtn = formLogin.find('button#btn_send_form_login');

    formLogin.validate({
      rules: {
        'login': 'required',
        'password': 'required'
      },
      messages: {
        'login': 'Le login est obligatoire',
        'password': 'Le password est obligatoire'
      },
      submitHandler: function () {

        $.ajax({
          type: 'POST',
          dataType: 'json',
          data: formLogin.serialize(),
          url: formLogin.attr('action'),
          success: function (response) {

            var reponse = JSON.stringify(response);

            console.log("reponse  " + reponse);

            var result = response.result;

            if (result > 0) {
              
              setTimeout( function() {
                window.location.href = response.nextUrl;
              }, 3000);
            }
            else {

              swal({
                title: 'Erreur de connexion',
                html: response.message,
                type: 'error'
              });
            }

            unlockBtn(formLoginBtn);
          },
          error: function (error) {

            console.log("error in login.js :: " + error);
            unlockBtn(formLoginBtn);
          }
        });
      }
    });
  }


  $('form#form_login').on('click', 'button#btn_send_form_login', function (e) {
    e.preventDefault();

    $('form#form_login').submit();
  });


});




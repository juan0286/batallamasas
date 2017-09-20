<%-- 
    Document   : login
    Created on : 13-sep-2017, 12:38:40
    Author     : TiranoJuan
--%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <script src="<c:url value="/js/jquery-1.4.3.js" />"></script>  
        <script>
            $('.message a').click(function(){
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });
        </script>                      
        <link href="<c:url value="/css/login.css" />" rel="stylesheet">
        <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="usuario"/>
      <input type="password" name="password"/>
      <input type="text" name="email address"/>
      <button>Crear</button>
      <p class="message">Ya estas registrado? <a href="#">Logueate</a></p>
    </form>
    <form class="login-form" action="ingresar.htm" method="POST">
      <input type="text" name="username"/>
      <input type="password" name="password"/>
      <button>loguear</button>
      <p class="message">no estas registrado? <a href="#">Crea una cuenta</a></p>
    </form>
      ${errorDetail}
  </div>
</div>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 4/5/14
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.--%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
        Object v = session.getAttribute ("usuarioLogueado");
if (v == null) 
        {
           response.sendRedirect("login.htm");
        }
%>

<html>
    <head>
        <link href="<c:url value="/css/login.css" />" rel="stylesheet">
        <link href="<c:url value="/css/main.css" />" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>
        <div id="logger">${usuarioLogueado}</div>        
        <div id="titulo">
            <h1>Welcome SpingMVC4 Home Page!</h1>
        </div>

        <h2>${usuarioLogueado}</h2>
        <h2>${loggedInUser}</h2>
    </body>
</html>

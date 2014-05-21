<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
  <head>
    <title>Hello World</title>
  </head>

<body>
  <div class="container">
    <h1>This is secured!</h1>
    <p>
      Hello <b><c:out value="${pageContext}"/></b>
    </p>
    <ul>
    <sec:authorize access="hasRole('ADMIN')">
		<li>
  		<s:url id="agregarURL" action="listUser">
		</s:url> <s:a href="%{agregarURL}">Listar Moderadores</s:a>
		</li>
	</sec:authorize>
	
  	<li><s:a href="#"> Ver Posts</s:a></li>
    <li><s:a href="#"> Ver Eventos</s:a></li>
    
    <sec:authorize access="hasAnyRole('ADMIN', 'STUDENT')">
  		<li><s:a href="#"> Crear un nuevo Post</s:a></li>
    	<li><s:a href="#"> Crear un nuevo Evento</s:a></li>
    </sec:authorize>
    
    <sec:authorize access="hasRole('MODERATOR')">
  		<li><s:a href="#"> Chequear Posts</s:a></li>
    	<li><s:a href="#"> Chequear Eventos</s:a></li>
    </sec:authorize>
    
    <sec:authorize access="isAuthenticated()">
  		<li><s:a href="#"> Comentar Posts</s:a></li>
    </sec:authorize>
    
    <sec:authorize access="not isAnonymous()">

  		<s:url id="registroURL" action="registroInvitados">
		</s:url> <s:a href="%{registroURL}">Registrarme</s:a>
		
	</sec:authorize>
    </ul>
    
    <c:url var="logoutUrl" value="/logout"/>
    <form class="form-inline" action="${logoutUrl}" method="post">
      <input type="submit" value="Log out" />
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </div>
</body>
</html>


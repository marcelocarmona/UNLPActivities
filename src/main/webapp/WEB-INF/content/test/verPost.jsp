<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:if test="post.privacity">
	<sec:authorize access="not isAuthenticated()">
 		<c:url var="loginUrl" value="login"/>
		<c:redirect url="${loginUrl}"></c:redirect>	
	</sec:authorize>
</s:if>

<h1><s:property value="post.title" /></h1>
<p><s:property value="post.content" /></p>

<h2>Comentarios</h2>
<s:iterator value="post.comments" status="commentStatus">
	<div><s:property value="user.username" />:
	<s:property value="content" /></div>
</s:iterator>

<sec:authorize access="not isAuthenticated()">
 		<s:url var="loginUrl" value="login"/>
		<s:a href="%{loginUrl}">Inicia sesión para comentar</s:a>	
</sec:authorize>


<sec:authorize access="isAuthenticated()">
	<h2>Comentá!</h2>
 		<s:form action="saveComment" method="post">
 			<s:textarea name="comment.content" label="Comentario" cols="40" rows="20"/>
 			<!--<s:hidden value="%{pageContext.request.remoteUser} " name="user"/>-->
 			<s:hidden value="%{post.id}" name="comment.post.id"/>
 			<s:submit value="Enviar" />
 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 		</s:form>
</sec:authorize>	

</body>
</html>
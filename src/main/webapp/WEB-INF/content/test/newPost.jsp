<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear un nuevo Post</title>
<s:head />
</head>
<body>
	<h2>Crea un nuevo Post</h2>
	<s:form action="savePost" method="post">
		<s:textfield name="title" label="Título" />
		<s:textfield name="description" label="Descripción" />
		<s:select  name="category.id" label="Categoría"
				headerKey="-1" headerValue="Selecciona una Categoría"
				list="categories" listKey="id" listValue="name"
				 /> 
		<!--<s:hidden value="%{pageContext.request.userPrincipal.name}" name="userName"/>-->
		<s:textarea name="content" label="Contenido" cols="80" rows="20"/>
		<s:checkbox name="privacity" label="Privado?" />
		
		<s:submit value="Guardar" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
	
</body>
</html>
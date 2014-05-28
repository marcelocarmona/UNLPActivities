<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Crea un nuevo Evento</h2>
	<s:form action="saveEvent" method="post">
		<s:textfield name="event.title" label="Título" />
		<s:textfield name="event.description" label="Descripción" />
		<s:textfield name="event.place" label="Lugar" />
		<s:date name="event.date"  />
		<s:select  name="event.category.id" label="Categoría"
				headerKey="-1" headerValue="Selecciona una Categoría"
				list="categories" listKey="id" listValue="name"
				 /> 
		
		<s:submit value="Guardar" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
</body>
</html>
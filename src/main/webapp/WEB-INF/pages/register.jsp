<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Invitados</title>
<s:head />
</head>
<body>

	<s:form action="register" method="post">
		<s:textfield name="username" label="Nombre de Usuario" />
		<s:textfield name="name" label="Nombre" />
		<s:textfield name="lastName" label="Apellido" />
		<s:password name="password" label="Contraseña" />
		<s:password name="password2" label="Repetir Contraseña" />
		<s:hidden name="authority" value="GUEST" />
		<s:submit value="Registrarme" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>

</body>
</html>
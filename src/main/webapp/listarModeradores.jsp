<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Moderadores</title>
<s:head />
</head>
<body>

<s:if test="editable">
	<s:form action="updateUser" method="post">
		<s:textfield value="%{user.username}" name="username" label="Nombre de Usuario" />
		<s:hidden value="%{user.id}" name="id"/>
		<s:hidden value="MODERATOR" name="authority"/>
		<s:textfield value="%{user.name}" name="name" label="Nombre" />
		<s:textfield value="%{user.lastName}" name="lastName" label="Apellido" />
		<s:password value="%{user.password}" name="password" label="Contraseña" />
		<s:password name="password2" label="Repetir Contraseña" />
		<s:submit value="Actualizar Usuario" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
</s:if>


<s:url id="agregarURL" action="registroModerador">
</s:url> <s:a href="%{agregarURL}">Agregar Moderador</s:a>

	<table>
		<thead>
			<tr>
				<td>Usuario</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Contraseña</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="userList" status="userStatus">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="id" /></td>
					<td>
						<s:url id="editURL" action="editUser">
							<s:param name="idUser" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{editURL}">Edit</s:a>
					</td>
					<td>
						<s:url id="deleteURL" action="deleteUser">
							<s:param name="idUser" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>
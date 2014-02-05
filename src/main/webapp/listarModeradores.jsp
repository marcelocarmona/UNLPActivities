<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="ttps.model.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Moderadores</title>
</head>
<body>
<% User user = (ttps.model.User)ActionContext.getContext().getValueStack().peek();
if (user.getId()!=0){ %>
<s:form action="updateUser" method="post">
	<s:hidden value="%{id}" name="id"/>
	<s:textfield value="%{name}" name="name" label="Nombre" />
	<s:textfield value="%{lastName}" name="lastName" label="Apellido" />
	<s:password value="%{password}" name="password" label="Contrase�a" />
	<s:password name="password2" label="Repetir Contrase�a" />
	<s:submit value="Actualizar Usuario" />
</s:form>
<%} %>

<s:url id="agregarURL" action="registroInvitados">
</s:url> <s:a href="%{agregarURL}">Agregar Moderador</s:a>
				
<table>
    <thead>
        <tr>
            <td>Nombre</td>
            <td>Apellido</td>
            <td>Contrase�a</td>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="userList" status="userStatus">
            <tr>
               	<td><s:property value="name" /></td>
				<td><s:property value="lastName" /></td>
				<td><s:property value="password" /></td>
                <td><s:url id="editURL" action="editUser">
				<s:param name="id" value="%{id}"></s:param>
				</s:url>
				<s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteUser">
				<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<table>
		<thead>
			<tr>
				<td>Usuario</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Contraseña</td>
				<td>id</td>
				<td>Edit</td>
				<td>Delete</td>
				<td>View</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="id" /></td>
					<td>
						<s:url id="editURL" action="edit">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> 
						<s:a href="%{editURL}">Edit</s:a>
					</td>
					<td><s:url id="deleteURL" action="delete">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url> 
						<s:a href="%{deleteURL}">Delete</s:a>
					</td>

					<td>
						<s:url id="viewURL" action="view">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url>
						<s:a href="%{viewURL}">View</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>



	<s:url id="createURL" action="edit"/>
	<s:a href="%{createURL}">Create</s:a>


</body>
</html>
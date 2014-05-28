<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Lista de Eventos</h2>
<table>
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Descripcion</td>
				<td>Lugar</td>
				<td>Fecha</td>
				<td>Categoria</td>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="events" status="eventStatus">
				<tr>
					<td><s:property value="title" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="place" /></td>
					<td><s:property value="date" /></td>
					<td><s:property value="category" /></td>
					
					<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">
					<td>
						<s:url id="deleteURL" action="deleteEvent">
							<s:param name="idEvent" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{deleteURL}">Delete</s:a>
					</td>
					</sec:authorize>
				</tr>
				
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
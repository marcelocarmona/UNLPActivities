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
<h2>Lista de Posts</h2>
<table>
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Descripcion</td>
				<td>Categoria</td>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="posts" status="postStatus">
				<tr>
					<td>
						<s:url id="verPostURL" action="verPost">
							<s:param name="idPost" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{verPostURL}"><s:property value="title" /></s:a>
					</td>
					<td><s:property value="description" /></td>
					<td><s:property value="category" /></td>
					
					
					<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">
					<td>
						<s:url id="deleteURL" action="deletePost">
							<s:param name="idPost" value="%{id}"></s:param>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categorias del Sitio UNLPActivities</title>
</head>
<body>
<s:url id="catURL" action="newCategory">
</s:url> <s:a href="%{catURL}">Agregar una Categoria nueva</s:a>

<s:if test="editable">
	<s:form action="saveCategory" method="post">
		<s:hidden value="%{category.id}" name="category.id"/>
		<s:textfield value="%{category.name}" name="category.name" label="Nombre" />
		<s:submit value="Guardar Categoria" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
</s:if>

<table>
		<thead>
			<tr>
				<td>id Categoria</td>
				<td>Nombre</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="categories" status="categoryStatus">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td>
						<s:url id="editURL" action="newCategory">
							<s:param name="idCategory" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{editURL}">Edit</s:a>
					</td>
					<td>
						<s:url id="deleteURL" action="deleteCategory">
							<s:param name="idCategory" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{deleteURL}">Delete</s:a>
					</td>
				</tr>
				
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />


<table>
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Descripcion</td>
				<td>Categoria</td>
				<td>Contenido</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="posts" status="postStatus">
				<tr>
					<td><s:property value="title" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="category" /></td>
					<td><s:property value="content" /></td>
					
					<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">
					<td>
						<s:url id="deleteURL" action="delete">
							<s:param name="idPost" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{deleteURL}">Delete</s:a>
					</td>
					</sec:authorize>
				</tr>
				
			</s:iterator>
		</tbody>
	</table>


<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
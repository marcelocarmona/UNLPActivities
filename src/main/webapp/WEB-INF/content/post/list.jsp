<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />

<div class="table-responsive panel panel-default">
<table class="table">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Categoria</th>
				<th>Contenido</th>
				<th>Tags</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="posts">
				<tr>
					<td>
						<s:url id="viewURL" action="view">
							<s:param name="idPost" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{viewURL}"><s:property value="title" /></s:a>
					</td>
					<td><s:property value="description" /></td>
					<td><s:property value="category" /></td>
					<td><s:property value="content" /></td>
					<td>
						<s:iterator value="tags">
							<s:property value="name" />
						</s:iterator>					
					</td>
					
					
					<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">
					<td>
						<s:url id="editURL" action="edit">
							<s:param name="idPost" value="%{id}"></s:param>
						</s:url> 
						<s:url id="deleteURL" action="delete">
							<s:param name="idPost"><s:property value="id" /></s:param>
						</s:url> 
						<s:url id="viewURL" action="view">
							<s:param name="idPost"><s:property value="id" /></s:param>
						</s:url>
							<div class="btn-group" >
								<s:a href="%{editURL}" cssClass="btn btn-xs btn-default">Edit</s:a>
								<s:a href="%{viewURL}" cssClass="btn btn-xs btn-default">View</s:a>
								<s:a href="%{deleteURL}" cssClass="btn btn-xs btn-default">Delete</s:a>
							</div>
					</td>
					</sec:authorize>
				</tr>
				
			</s:iterator>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<jsp:include page="/WEB-INF/content/layout/header.jsp" />
<div class="table-responsive panel panel-default">
	<table class="table">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Lugar</th>
				<th>Fecha</th>
				<th>Categoria</th>
				<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')"><th>Actions</th></sec:authorize>
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
						<td><s:url id="editURL" action="edit">
								<s:param name="idEvent" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}"><i class="glyphicon glyphicon-edit" data-original-title="edit"></i></s:a>
						
							
							<s:url id="deleteURL" action="delete">
								<s:param name="idEvent" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}"><i class="glyphicon glyphicon-trash" data-original-title="delete"></i></s:a>
						</td>	
					
					</sec:authorize>
				</tr>

			</s:iterator>
		</tbody>
	</table>
</div>
<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
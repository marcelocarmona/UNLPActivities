<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />



<div class="table-responsive panel panel-default">
	<table class="table table-responsive " >
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Gender</th>
				<th>Mail</th>
				<th>Birthday</th>
				<th>nationality</th>
				<th>profession</th>
				<th>Role</th>
				<sec:authorize access="hasRole('ADMIN')"><th>Actions</th></sec:authorize>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users">
				<tr>
					<td><s:property value="id" /></td>			
					<td><s:property value="name" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="gender" /></td>
					<td><s:property value="mail" /></td>
					<td><s:property value="birthday" /></td>
					<td><s:property value="nationality" /></td>
					<td><s:property value="profession" /></td>
					<td><s:property value="role" /></td>
					
					<td>
						<s:url id="editURL" action="edit">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> 
						<s:url id="deleteURL" action="delete">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url> 
						<sec:authorize access="hasAnyRole('ADMIN')">
							<div class="btn-group" >
								<s:a href="%{deleteURL}"><i class="glyphicon glyphicon-trash" data-original-title="delete"></i></s:a>
								<s:a href="%{editURL}"><i class="glyphicon glyphicon-edit" data-original-title="edit"></i></s:a>
							</div>
						</sec:authorize>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>


<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
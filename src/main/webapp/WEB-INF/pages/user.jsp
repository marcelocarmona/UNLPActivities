<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<s:if test="editable">
	<div class="panel panel-default">
		<div class="panel-body">
			<s:form action="updateUser" method="post">
				<s:textfield value="%{user.username}" name="username" label="Username" />
				<s:hidden value="%{user.id}" name="id" />
				<s:hidden value="MODERATOR" name="authority" />
				<s:radio label="Roles" list="roles"></s:radio>
				<s:textfield value="%{user.name}" name="name" label="Nombre" />
				<s:textfield value="%{user.lastName}" name="lastName" label="Apellido" />
				<s:password value="%{user.password}" name="password" label="Contraseña" required="true"/>
				<s:password name="password2" label="Repetir Contraseña" required="true" />
				<s:submit value="Actualizar Usuario" />
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</s:form>
		</div>
	</div>
</s:if>






<div class="panel panel-default">
		<!--   <div class="panel-heading">Panel heading</div> -->
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Name</th>
					<th>Lastname</th>
					<th>password</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<s:iterator value="userList" status="userStatus">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="password" /></td>

					<td class="text-center">
						<s:url id="editURL" action="edit-user">
							<s:param name="idUser" value="%{id}"></s:param>
						</s:url> 
						<a class='btn btn-info btn-xs' href="${editURL}">
							<span class="glyphicon glyphicon-edit"></span> 
							Edit
						</a> 
						
						<s:url id="deleteURL" action="delete-user">
							<s:param name="idUser" value="%{id}"></s:param>
						</s:url> 
						<a class='btn btn-danger btn-xs' href="${deleteURL}"> 
						<span class="glyphicon glyphicon-remove"></span> 
						Delete
						</a>
					</td>
				</tr>
			</s:iterator>

		</table>
	</div>
	
	

<s:url id="registerURL" action="registroModerador"/>
<a class='btn btn-success btn-xs' href="${registerURL}">Agregar Moderador</a>
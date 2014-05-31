<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="layout/header.jsp" />

<div class="panel panel-default">
	<div class="panel-heading">Información del trabajo final</div>
	<div class="panel-body">

		<h4>Frameworks utilizados</h4>

			<ul>
				<li>Spring Data Jpa</li>
				<li>Hibernate</li>
				<li>Spring Security</li>
				<li>Struts 2</li>
				<li>Bootstrap</li>
			</ul>
		<h4>Permisos de Usuarios</h4>
					<ul>
				<li><b>Guest</b>: Ver post y comentar</li>
				<li><b>Student</b>: Crear, comentar post. crear y ver eventos</li>
				<li><b>Moderator</b>: puede hacer todo menos modificar y/o crear usuarios</li>
				<li><b>Admin</b>: tiene todos los permisos</li>
			</ul>
			
		<h4>Usuarios por defecto para hacer pruebas</h4>
					<ul>
				<li><b>Guest</b>: <b>username</b>:moderator <b>password</b>:moderator</li>
				<li><b>Student</b>: <b>username</b>:moderator <b>password</b>:moderator</li>
				<li><b>Moderator</b>: <b>username</b>:moderator <b>password</b>:moderator</li>
				<li><b>Admin</b>: <b>username</b>:admin <b>password</b>:admin</li>
			</ul>


	</div>
</div>




<jsp:include page="layout/footer.jsp" />



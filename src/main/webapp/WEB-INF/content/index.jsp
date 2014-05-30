<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="layout/header.jsp" />

<div class="panel panel-default">
	<div class="panel-heading">Información del trabajo final</div>
	<div class="panel-body">

		<p>Frameworks utilizados</p>

			<ul class="task-list">
				<li>Spring Data Jpa</li>
				<li>Hibernate</li>
				<li>Spring Security</li>
				<li>Struts 2</li>
				<li>Bootstrap</li>
			</ul>

	</div>
</div>

<p> Guest: solo tiene permiso para ver post y comentar</p>
<p> Student: pueden ver, crear, comentar post. crear y ver eventos</p>
<p> Moderator: puede hacer todo menos modificar y/o crear usuarios</p>
<p> Admin: tiene todos los permisos</p>


<jsp:include page="layout/footer.jsp" />



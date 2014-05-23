<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />


	<s:form action="save" method="post" theme="bootstrap"
		cssClass="form-horizontal" label="Crea un nuevo Post">
		<s:hidden name="post.user.id" value="1"/>
		
		<s:textfield name="post.title" label="T�tulo" />
		<s:textfield name="post.description" label="Descripci�n" />
		
		<s:select  name="post.category.id" label="Categor�a"
				headerKey="-1" headerValue="Selecciona una Categor�a"
				list="categories" listKey="id" listValue="name" /> 
		
		<s:textarea name="post.content" label="Contenido" cols="80" rows="20"/>
		<s:checkbox name="post.privacity" label="Privado?" />
		
		<s:submit value="Guardar" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
	

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
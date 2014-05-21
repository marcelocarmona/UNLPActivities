<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<sj:head  />
<sb:head />
</head>
<body>

	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	
	

<div class="container">
	<s:form action="save" method="post" theme="bootstrap"
		cssClass="form-horizontal" label="Crea un nuevo Post">
		<s:hidden name="post.user.id" value="1"/>
		<s:textfield name="post.title" label="Título" />
		<s:textfield name="post.description" label="Descripción" />
		
		<s:select  name="post.category.id" label="Categoría"
				headerKey="-1" headerValue="Selecciona una Categoría"
				list="categories" listKey="id" listValue="name" /> 
		
		<s:textarea name="post.content" label="Contenido" cols="80" rows="20"/>
		<s:checkbox name="post.privacity" label="Privado?" />
		
		<s:submit value="Guardar" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
</div>
	
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="layout/header.jsp" />


${session["SPRING_SECURITY_CONTEXT"]}


<h3>Index de Prueba</h3>

<br />Desde un JSP
<br />Objeto User : <s:property value="#session.SPRING_SECURITY_CONTEXT.authentication.principal" />
<br />User role: <s:property value="#session.SPRING_SECURITY_CONTEXT.authentication.authorities" />
<br />
<br />
<br />Desde un Action (hay que castear)
<p>
	System.out.println(((org.springframework.security.core.context.SecurityContext)
	ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getAuthorities());</p>



<br />User : <s:property value="#session.SPRING_SECURITY_CONTEXT.authentication.principal.id" />
<jsp:include page="layout/footer.jsp" />



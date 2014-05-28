<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="/WEB-INF/content/layout/header.jsp" />

<div class="panel panel-default">
	<div class="panel-body">
		<s:form action="save" method="post" theme="bootstrap"
			cssClass="form-horizontal" label="Event">
			<s:textfield name="event.title" label="Título" />
			<s:textfield name="event.description" label="Descripción" />
			<s:textfield name="event.place" label="Lugar" />
			<%-- 		<s:date name="event.date"  /> --%>
			<s:select name="event.category.id" label="Categoría"
				list="categories" listKey="id" listValue="name" />

			<s:submit value="Save" cssClass="btn btn-primary btn-block" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</s:form>
	</div>
</div>
<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
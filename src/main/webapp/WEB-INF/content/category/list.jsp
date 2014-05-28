<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />

<div class="table-responsive panel panel-default">
<div class="panel-body">
	<s:form action="save" method="post" theme="bootstrap"
		label="New Category">
		<s:hidden value="%{category.id}" name="category.id"/>
		<s:textfield value="%{category.name}" name="category.name" label="Name" />
		<s:submit value="Save" cssClass="btn btn-primary btn-block"  />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>
	</div>

	<ul class="list-group">
		<s:iterator value="categories">
			<li class="list-group-item">
				<s:url id="deleteURL" action="delete">
					<s:param name="idCategory" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}"><i class="glyphicon glyphicon-trash"></i></s:a>
				<s:property value="name" />
			</li>
		</s:iterator>
	</ul>
</div>

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
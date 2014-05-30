<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$('i').tooltip();
	});
</script>

<div class="panel panel-default">
<div class="panel-heading">
	<s:form id="filter-form" action="filter-processing" method="post" theme="bootstrap"
		label="Filter">
		
		<s:select name="idCategory" label="Category" 
		list="categories" listKey="id" listValue="name" onchange="this.form.submit()"/>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</s:form>


</div>
	<div class="list-group">
		<s:iterator value="posts">
				<s:url id="editURL" action="edit">
					<s:param name="idPost" value="%{id}"></s:param>
				</s:url> 
				<s:url id="deleteURL" action="delete-processing">
					<s:param name="idPost"><s:property value="id" /></s:param>
				</s:url> 
				<s:url id="viewURL" action="view">
					<s:param name="idPost"><s:property value="id" /></s:param>
				</s:url>
			<div class="list-group-item">
				<s:a href="%{deleteURL}"><i class="glyphicon glyphicon-trash" data-original-title="delete"></i></s:a>
				<s:a href="%{editURL}"><i class="glyphicon glyphicon-edit" data-original-title="edit"></i></s:a>
				<s:a href="%{viewURL}"><s:property value="title"/></s:a>
				
				<span class="badge"><s:property value="category" /></span>
				
				
			</div>
		</s:iterator>
	</div>
</div>

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
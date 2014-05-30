<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />


<div class="panel panel-default">
	<div class="panel-body">
		<s:form action="edit-processing" method="post" theme="bootstrap"
			cssClass="form-horizontal" label="Post">
			
			<!--  hiddens que se tienen que mantener -->
			<s:hidden name="post.id"  />
			<s:hidden name="post.user.id" />

			<s:textfield name="post.title" label="Title" />
			<s:textfield name="post.description" label="Description" />

			<s:select name="post.category.id" label="Category" 
				list="categories" listKey="id" listValue="name" />
				
<%-- 	<s:textfield name="post.category.id" label="categories" /> --%>
	
			<s:textarea name="post.content" label="Content" cols="80" rows="20" />

			<s:textfield label="Tags" name="tagStrings" data-role="tagsinput"
				placeholder="Add tags"  />

			<s:checkbox name="post.privacity" label="Privado?" />

			<s:submit value="Save" cssClass="btn btn-primary btn-block" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</s:form>
	</div>
</div>

<!-- js and css inputtag -->
<!-- http://timschlechter.github.io/bootstrap-tagsinput/examples/ -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tagsinput/bootstrap-tagsinput.css" media="screen" />
<script src="${pageContext.request.contextPath}/tagsinput/bootstrap-tagsinput-angular.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/tagsinput/bootstrap-tagsinput.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/tagsinput/bootstrap-tagsinput.js" type="text/javascript"></script>


<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
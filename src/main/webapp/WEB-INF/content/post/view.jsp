<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/content/layout/header.jsp" />

<s:if test="post.privacity">
	<sec:authorize access="not isAuthenticated()">
		<c:url var="loginUrl" value="../login" />
		<c:redirect url="${loginUrl}"></c:redirect>
	</sec:authorize>
</s:if>


<div class="panel panel-default">
<div class="panel-heading">
  <div class="">
    <s:property value="post.title" />
    <span class="badge" style="float:right"><s:property value="post.user.username" /></span>
  </div>
</div>

	<div class="panel-body">
		<s:property value="post.content" />
	</div>
	<div class="panel-footer">
		<s:iterator value="post.tags">
			<span class="tag label label-info"><s:property value="name" /></span>
		</s:iterator>
	</div>
</div>


	<div class="panel panel-default">
		<sec:authorize access="isAuthenticated()">
			<div class="panel-heading">
				<s:form action="/comment/create-processing" method="post"
					theme="bootstrap" label="Comment">
					<s:textarea name="comment.content" cssClass="form-control" />
					<s:hidden value="2 " name="comment.user.id" />
					<s:hidden value="%{post.id}" name="comment.post.id" />
	
					<s:submit value="Enviar" cssClass="btn btn-default" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</s:form>
			</div>
		</sec:authorize>
		<ul class="list-group">
			<s:iterator value="post.comments" status="commentStatus">
				<li class="list-group-item">
					<h4 class="list-group-item-heading">
						<s:property value="user.username" />
					</h4>
					<p class="list-group-item-text">
						<s:property value="content" />
					</p>

				</li>
			</s:iterator>
		</ul>
	</div>


<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
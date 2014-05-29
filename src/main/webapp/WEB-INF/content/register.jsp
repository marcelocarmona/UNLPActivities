<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />

	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />

<div class="panel panel-default">
<div class="panel-body">
	<s:form action="saveGuest" method="post" theme="bootstrap"
		cssClass="form-horizontal " label="User Form">
		
		<s:textfield 
			name="user.username" 
			label="User Name" 
			tooltip="Enter your name here" />
			
			<s:password name="user.password"
						label="Password" 
						tooltip="Enter your password here"/>
		
		<s:submit 
			value="Save" 
			cssClass="btn btn-primary btn-block" />
			
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</s:form>
	</div>
</div>

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
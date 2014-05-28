<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />

	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />

<div class="panel panel-default">
<div class="panel-body">
	<s:form action="save" method="post" theme="bootstrap"
		cssClass="form-horizontal " label="User Form">
		
		<s:hidden 
			name="user.id"/>
		
		<s:textfield 
			name="user.name" 
			label="Name" 
			tooltip="Enter your name here" />
			
		<s:textfield 
			name="user.lastName" 
			label="Last Name" 
			tooltip="Enter your last name here" />
		
		<s:radio 
			name="user.gender" 
			label="Gender" 
			list="genders" />
		
		<s:textfield 
			name="user.mail" 
			label="Mail" 
			tooltip="Enter your mail here" 
			type="email"/>
 		
 		<sj:datepicker 
             name="user.birthday"
             parentTheme="bootstrap" 
             label="Birthday" 
             tooltip="Select a date" 
             cssClass="form-control" 
             elementCssClass="col-sm-5" 
             showOn="focus"
             displayFormat="dd/mm/yy" 
             inputAppendIcon="calendar"/> 

			
		<s:textfield 
			name="user.nationality" 
			label="Nationality" />
			
		<s:textfield 
			name="user.profession" 
			label="Profession" />
			
		<s:textfield 
			name="user.username" 
			label="Username"/>
			
		<s:textfield 
			name="user.password" 
			label="Password" />
			
		<s:radio 
			name="user.role" 
			label="Roles" 
			list="roles" />
			
		<s:checkbox 
			name="user.accountNonExpired" 
			label="Account Non Expired" />
			
		<s:checkbox 
			name="user.accountNonLocked" 
			label="Account Non Locked" />
			
		<s:checkbox 
			name="user.credentialsNonExpired"
			label="Credentials Non Expired" />
			
		<s:checkbox 
			name="user.enabled" 
			label="Enabled: " />
			
			<div class="highlight">
		<s:submit 
			value="Save" 
			cssClass="btn btn-primary btn-block" />
			</div>
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</s:form>
	</div>
</div>

<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
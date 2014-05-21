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
	${user.authorities}
	<s:form action="save" method="post" theme="bootstrap"
		cssClass="form-horizontal" label="User Form">
		
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
             value="%{user.birthday}"
             parentTheme="bootstrap" 
             label="Birthday" 
             tooltip="Select a date" 
             cssClass="form-control" 
             elementCssClass="col-sm-5" 
             showOn="focus" 
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
			
		<s:checkboxlist 
			name="user.authorities" 
			labelposition="inline"
			label="Authorities"
			list="authorities" />
			
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
			
		<%-- 		<s:hidden name="authority" value="GUEST" /> --%>
		
		<s:submit 
			value="Save" 
			cssClass="btn btn-primary" />
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</s:form>
</div>


</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>UNLP Activities</title>
<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<sj:head  />
<sb:head />
<style type="text/css">
/* Sticky footer styles
-------------------------------------------------- */
html,body {
	height: 100%;
	/* The html and body elements cannot have any padding or margin. */
}

/* Wrapper for page content to push down footer */
#wrap {
	min-height: 100%;
	height: auto;
	/* Negative indent footer by its height */
	margin: 0 auto -60px;
	/* Pad bottom by footer height */
	padding: 0 0 60px;
}

/* Set the fixed height of the footer here */
#footer {
	height: 60px;
	background-color: #f5f5f5;
}

/* Custom page CSS
-------------------------------------------------- */
/* Not required for template or sticky footer method. */
#wrap>.container {
	padding: 60px 15px 0;
}

.container .text-muted {
	margin: 20px 0;
}

/* Bootstrap rewrite
-------------------------------------------------- */
.help-block {
display: block;
margin-top: 5px;
margin-bottom: 10px;
padding: 5px;
color: #737373;
border: 1px solid transparent;
border-radius: 4px;
}
}

</style>
</head>
<body>

	<div id="wrap">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->

			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/index">UNLPActivities</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a 	href="#" 
								class="dropdown-toggle"
								data-toggle="dropdown">
								Posts
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/post/list">list</a></li>
								<sec:authorize access="hasAnyRole('ADMIN','MODERATOR','STUDENT')"><li><a href="${pageContext.request.contextPath}/post/create">create</a></li></sec:authorize>
							</ul>
						</li>
						<sec:authorize access="hasAnyRole('ADMIN','MODERATOR','STUDENT')">
							<li class="dropdown">
								<a 	href="#" 
									class="dropdown-toggle"
									data-toggle="dropdown">
									Events
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/event/list">list</a></li>
									<li><a href="${pageContext.request.contextPath}/event/edit">create</a></li>
								</ul>
							</li>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ADMIN','MODERATOR')">
							<li>
								<a href="${pageContext.request.contextPath}/category/list">Categories</a>
							</li>
						
							<li class="dropdown">
								<a 	href="#" 
									class="dropdown-toggle"
									data-toggle="dropdown">
									Users
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/user/list">list</a></li>
									<sec:authorize access="hasRole('ADMIN')"><li><a href="${pageContext.request.contextPath}/user/edit">create</a></li></sec:authorize>
								</ul>
							</li>
						</sec:authorize>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<sec:authorize access="isAnonymous()">
						<li class="dropdown">
							<a 	href="${pageContext.request.contextPath}/register" 
								>
								Sign up
								
							</a>
						</li>
						</sec:authorize>
					<li>
						<s:if test="%{#session.SPRING_SECURITY_CONTEXT.authentication.authenticated}">
							<li class="dropdown">
								<a 	href="#" 
									class="dropdown-toggle"
									data-toggle="dropdown">
									<i class="glyphicon glyphicon-user"></i>
									<s:property value="#session.SPRING_SECURITY_CONTEXT.authentication.principal.username" />
									[<s:property value="#session.SPRING_SECURITY_CONTEXT.authentication.principal.role" />]
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/user/perfil">Perfil</a></li>
									<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
								</ul>
							</li>

						</s:if>
						<s:else>
						    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
						</s:else>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</nav>


		<div class="container">
		
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('i').tooltip();
	});
	</script>
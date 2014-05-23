<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

/* CSS solo para esta entrega  ******************REFACTORING********************
-------------------------------------------------- */
.label {
	color: black;
	font-size: 14px;
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
								Users
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/user/list">list</a></li>
								<li><a href="${pageContext.request.contextPath}/user/edit">create</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a 	href="#" 
								class="dropdown-toggle"
								data-toggle="dropdown">
								Posts
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/post/list">list</a></li>
								<li><a href="${pageContext.request.contextPath}/post/edit">create</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a 	href="#" 
								class="dropdown-toggle"
								data-toggle="dropdown">
								Events
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">list</a></li>
								<li><a href="#">create</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a 	href="#" 
								class="dropdown-toggle"
								data-toggle="dropdown">
								Categories
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">list</a></li>
								<li><a href="#">create</a></li>
							</ul>
						</li>


					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<s:if test="%{#session.SPRING_SECURITY_CONTEXT.authentication.authenticated}">
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</s:if>
						<s:else>
						    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
						</s:else>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</nav>


		<div class="container">
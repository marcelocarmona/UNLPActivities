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

<div class="container">




	<table class="table " >
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Gender</th>
				<th>Mail</th>
				<th>Birthday</th>
				<th>nationality</th>
				<th>profession</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users">
				<tr>
					<td><s:property value="id" /></td>			
					<td><s:property value="name" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="gender" /></td>
					<td><s:property value="mail" /></td>
					<td><s:property value="birthday" /></td>
					<td><s:property value="nationality" /></td>
					<td><s:property value="profession" /></td>
					
					<td>
						<s:url id="editURL" action="edit">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> 
						<s:url id="deleteURL" action="delete">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url> 
						<s:url id="viewURL" action="view">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url>
							<div class="btn-group" >
								<s:a href="%{editURL}" cssClass="btn btn-xs btn-default">Edit</s:a>
								<s:a href="%{viewURL}" cssClass="btn btn-xs btn-default">View</s:a>
								<s:a href="%{deleteURL}" cssClass="btn btn-xs btn-default">Delete</s:a>
							</div>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	<s:url id="createURL" action="edit"/>
	<s:a href="%{createURL}" cssClass="btn btn-primary">Create</s:a>


</div>


</body>
</html>
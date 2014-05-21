<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
</head>
<body>



<br>Id: <s:property value="user.id" />
<br>Name: <s:property value="user.name" />
<br>Last Name: <s:property value="user.lastName" />
<br>Username: <s:property value="user.username" />
<br>Password: <s:property value="user.password" />
<br>Authorities: <s:property value="user.authorities" />
<br>Account Non Expired: <s:property value="user.accountNonExpired" />
<br>Account Non Locked: <s:property value="user.accountNonLocked" />
<br>Credentials Non Expired: <s:property value="user.credentialsNonExpired" />
<br>Enabled: <s:property value="user.enabled" />


</body>
</html>
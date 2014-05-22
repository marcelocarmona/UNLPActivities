<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<title>My Secured Page</title>
</head>
<body>
    <h3>Index de Prueba</h3>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    <s:action name="logout">Logout</s:action>
    <s:action name="login">Login</s:action>
    <s:a action="logout" >Logout</s:a>
    <s:a action="login">Login</s:a>
    
    <div>
    
     <s:a action="user/list">User/list</s:a>
    </div>
</body>
</html>
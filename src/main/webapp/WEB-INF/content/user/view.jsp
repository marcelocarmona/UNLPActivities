<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include  page="/WEB-INF/content/layout/header.jsp" />



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


<jsp:include page="/WEB-INF/content/layout/footer.jsp" />
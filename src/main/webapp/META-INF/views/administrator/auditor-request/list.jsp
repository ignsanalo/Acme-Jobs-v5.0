<%-- elreyrata 25.10.19

		list.jsp

 --%>
 
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.auditor-request.list.label.firm" path="firm" width="20%"/>
	<acme:list-column code="administrator.auditor-request.list.label.statement" path="statement" width="20%"/>
	<acme:list-column code="administrator.auditor-request.list.label.status" path="status" width="40%"/>
	
</acme:list>
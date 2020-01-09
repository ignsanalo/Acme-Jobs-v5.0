<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="auditor.auditrecord.form.label.title" path="title"/>
	<acme:form-moment code="auditor.auditrecord.form.label.moment" path="moment"/>
	<acme:form-textbox code="auditor.auditrecord.form.label.body" path="body"/>
	<acme:form-textbox code="auditor.auditrecord.form.label.status" path="finalMode"/>
	

	
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>
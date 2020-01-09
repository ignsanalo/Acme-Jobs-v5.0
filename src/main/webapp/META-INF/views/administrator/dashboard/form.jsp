<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-double code="administrator.dashboard.form.jobsRatio" path="jobsRatio"/>
	<acme:form-double code="administrator.dashboard.form.answerRatio" path="answerRatio"/>
	<acme:form-double code="administrator.dashboard.form.protectedRatio" path="protectedRatio"/>
	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>
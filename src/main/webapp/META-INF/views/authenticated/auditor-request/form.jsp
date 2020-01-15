<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<jstl:if test="${auditorRequest.id != 0 }">
<acme:message code="master.menu.user-account.become-auditor.pending" />
</jstl:if>

<jstl:if test="${auditorRequest.id == 0 }">
<acme:form>
	<acme:form-textbox code="authenticated.auditor-request-request.form.label.firm" path="firm" />
	<acme:form-textbox code="authenticated.auditor-request.form.label.statement" path="statement" />
	<acme:form-submit test="${command == 'create'}" code="authenticated.auditor-request.form.button.request"
		action="/authenticated/auditor-request/create" />
	<acme:form-return code="authenticated.auditor-request.form.button.return" />
</acme:form>
</jstl:if>
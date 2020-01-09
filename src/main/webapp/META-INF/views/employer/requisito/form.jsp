<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.requisito.form.label.text" path="text" />
	<acme:form-textbox code="employer.requisito.form.label.moreInfo" path="moreInfo" />
	
	<acme:form-submit test="${command =='create' }" code="employer.requisito.form.button.create" action="/employer/requisito/create?id=${id}" />
	

	<acme:form-return code="employer.requisito.form.button.return" />

</acme:form>
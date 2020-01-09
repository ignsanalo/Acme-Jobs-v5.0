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

<acme:form>
	<acme:form-textbox code="administrator.investorrecords.form.label.name" path="name"/>
	<acme:form-textbox code="administrator.investorrecords.form.label.sector" path="sector"/>
	<acme:form-textarea code="administrator.investorrecords.form.label.statement" path="statement"/>
	<acme:form-integer code="administrator.investorrecords.form.label.stars" path="stars" placeholder="0-5"/>
	
	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecords.form.button.update"
		action="/administrator/investorrecords/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecords.form.button.delete"
		action="/administrator/investorrecords/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.investorrecords.form.button.create"
		action="/administrator/investorrecords/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.investorrecords.form.button.update"
		action="/administrator/investorrecords/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.investorrecords.form.button.delete"
		action="/administrator/investorrecords/delete" />
	
	<acme:form-return code="administrator.investorrecords.form.button.return"/>
</acme:form>
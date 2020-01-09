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
  
  <acme:form-textbox code="authenticated.participates-in.form.label.thread-title" path="thread.title" readonly="true"/>
  
  <jstl:if test="${command == 'add-participant'}">
  
    <acme:form-select code="authenticated.participates-in.form.label.add-participant" path="participantId">
      <jstl:forEach items="${allAuthenticated}" var="Authenticated">
        <acme:form-option code="${Authenticated.userAccount.username}" value="${Authenticated.id}"/>
      </jstl:forEach>
    </acme:form-select>
    
  </jstl:if>
  
  <jstl:if test="${command != 'add-participant'}">

    <acme:form-textbox code="authenticated.participates-in.form.label.username" path="participant.userAccount.username" readonly="true"/>
    <acme:form-textbox code="authenticated.participates-in.form.label.fullname" path="participant.userAccount.identity.fullName" readonly="true"/>  
  
  </jstl:if>

  <acme:form-submit test="${command == 'add-participant'}" code="authenticated.participates-in.form.button.add" 
  	action="/authenticated/participates-in/add-participant?threadId=${thread.id}"/>  
  
  <acme:form-submit test="${command != 'add-participant' && isOwner}" code="authenticated.participates-in.form.button.delete" 
  	action="/authenticated/participates-in/remove-participant"/>
  
    <acme:form-return code="authenticated.participates-in.form.button.return"/>
</acme:form>
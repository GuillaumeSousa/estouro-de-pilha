
<%@ page import="fr.isima.estouroDePilha.Tag" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-tag" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tag">
			
				<g:if test="${tagInstance?.tagname}">
				<li class="fieldcontain">
					<span id="tagname-label" class="property-label"><g:message code="tag.tagname.label" default="Tagname" /></span>
					
						<span class="property-value" aria-labelledby="tagname-label"><g:fieldValue bean="${tagInstance}" field="tagname"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${tagInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="tag.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${tagInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tagInstance?.questions}">
				<li class="fieldcontain">
					<span id="questions-label" class="property-label"><g:message code="tag.questions.label" default="Questions" /></span>
					
						<g:each in="${tagInstance.questions}" var="q">
						<span class="property-value" aria-labelledby="questions-label"><g:link controller="question" action="show" id="${q.id}">${q.subject}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tagInstance?.id}" />
					<g:link class="edit" action="edit" id="${tagInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

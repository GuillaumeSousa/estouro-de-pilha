
<%@ page import="fr.isima.estouroDePilha.Badge" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'badge.label', default: 'Badge')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-badge" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-badge" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list badge">
			
				<g:if test="${badgeInstance?.badgeName}">
				<li class="fieldcontain">
					<span id="badgeName-label" class="property-label"><g:message code="badge.badgeName.label" default="Badge Name" /></span>
					
						<span class="property-value" aria-labelledby="badgeName-label"><g:fieldValue bean="${badgeInstance}" field="badgeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${badgeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="badge.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${badgeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${badgeInstance?.users}">
				<li class="fieldcontain">
					<span id="users-label" class="property-label"><g:message code="badge.users.label" default="Users" /></span>	
						<g:each in="${badgeInstance.users}" var="u">
						<span class="property-value" aria-labelledby="users-label"><g:link controller="user" action="show" id="${u.id}">${u.pseudo}</g:link></span>
						</g:each>
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>

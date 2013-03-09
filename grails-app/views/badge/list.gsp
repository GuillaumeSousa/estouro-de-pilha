
<%@ page import="fr.isima.estouroDePilha.Badge" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'badge.label', default: 'Badge')}" />
		<title><g:message code="badge.list.title" /></title>
	</head>
	<body>
		<a href="#list-badge" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-badge" class="content scaffold-list" role="main">
			<h1><g:message code="badge.list.title" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<tbody>
				<g:each in="${badgeInstanceList}" status="i" var="badgeInstance">
						<td>
							<g:link action="show" id="${badgeInstance.id}">${fieldValue(bean: badgeInstance, field: "badgeName")}</g:link>
							<div class="excerpt">
							${message(code: 'badge.owners', default: 'Owners')} : ${badgeInstance.users.size()}<br>
							${badgeInstance.description}<br>	
							</div>
						</td>
					<%if((i+1)%4 == 0) { %>
					<tr></tr>
					<%} %>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${badgeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

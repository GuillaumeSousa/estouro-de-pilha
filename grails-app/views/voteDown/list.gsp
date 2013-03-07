
<%@ page import="fr.isima.estouroDePilha.VoteDown" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'voteDown.label', default: 'VoteDown')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-voteDown" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-voteDown" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="voteDown.contributor.label" default="Contributor" /></th>
					
						<th><g:message code="voteDown.post.label" default="Post" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${voteDownInstanceList}" status="i" var="voteDownInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${voteDownInstance.id}">${fieldValue(bean: voteDownInstance, field: "contributor")}</g:link></td>
					
						<td>${fieldValue(bean: voteDownInstance, field: "post")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${voteDownInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

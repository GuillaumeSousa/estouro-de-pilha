
<%@ page import="fr.isima.estouroDePilha.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li>
					<g:newUserControl/>
				</li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<table>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
						<td>
							<g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "pseudo")}</g:link>
							<div class="excerpt">
							${message(code: 'user.reputation', default: 'reputation')} : ${userInstance.reputation}<br>
							${message(code: 'user.questions', default: 'questions')} : ${userInstance.questions.size()}<br>
							${message(code: 'user.answers', default: 'answers')} : ${userInstance.answers.size()}	
							</div>
						</td>
					<%if((i+1)%4 == 0) { %>
					<tr></tr>
					<%} %>
				</g:each>
				</tbody>
			</table>
			
			<div class="pagination">
				<g:paginate total="${userInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

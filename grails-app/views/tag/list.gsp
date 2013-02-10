
<%@ page import="fr.isima.estouroDePilha.Tag" %>
<!DOCTYPE html>
<html>

	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tag" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tag" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="tags-browser">
				<tbody>
				<g:each in="${tagInstanceList}" status="i" var="tagInstance">
						<td class="tag-cell">
							<g:link class="post-tag" action="taggedQuestions" id="${tagInstance.id}">${fieldValue(bean: tagInstance, field: "tagname")}</g:link>
							<div class="excerpt">${fieldValue(bean: tagInstance, field: "description")}
							</div>
						</td>
					<%if((i+1)%4 == 0) { %>
					<tr></tr>
					<%} %>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tagInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

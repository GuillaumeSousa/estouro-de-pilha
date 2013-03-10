
<%@ page import="fr.isima.estouroDePilha.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="question.list.title" /></title>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" class="content scaffold-list" role="main">
			<h1><g:message code="question.list.title" /></h1>
			<!-- List questions -->
			<g:render template="/question/listQuestionsPaginated" model="[questionList: questionInstanceList, questionNumber: questionInstanceTotal]" />
		</div>
	</body>
</html>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Estouro de Pilha</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Menu</h1>
			<ul>
				<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
					<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
				</g:each>
			</ul>
			<h1>Recent Tags</h1>
		</div>
		<div id="page-body" role="main">
			<div>
				<g:each in="${questionList}" var="question">
					<p>${question.subject}</p>
				</g:each>
				<div id="list-question" class="content scaffold-list" role="main">
					<h1><g:message code="default.list.label" args="[entityName]" /></h1>
					<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
					</g:if>
					<table>
						<thead>
							<tr>
								<g:sortableColumn property="author" title="${message(code: 'question.author.label', default: 'Author')}" />
							
								<g:sortableColumn property="message" title="${message(code: 'question.message.label', default: 'Message')}" />
							
								<g:sortableColumn property="nbViews" title="${message(code: 'question.nbViews.label', default: 'Nb Views')}" />
							
								<g:sortableColumn property="nbVotes" title="${message(code: 'question.nbVotes.label', default: 'Nb Votes')}" />
							
								<g:sortableColumn property="postedDate" title="${message(code: 'question.postedDate.label', default: 'Posted Date')}" />
							
							</tr>
						</thead>
						<tbody>
						<g:each in="${questionList}" status="i" var="questionInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							
								<td>${fieldValue(bean: questionInstance, field: "author")}</td>
							
								<td>${fieldValue(bean: questionInstance, field: "message")}</td>
							
								<td>${fieldValue(bean: questionInstance, field: "nbViews")}</td>
							
								<td>${fieldValue(bean: questionInstance, field: "nbVotes")}</td>
							
								<td><g:formatDate date="${questionInstance.postedDate}" /></td>
							
							</tr>
						</g:each>
						</tbody>
					</table>
					<div class="pagination">
						<g:paginate total="${questionNumber}" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<!DOCTYPE html>
<%@page import="javax.servlet.jsp.tagext.Tag"%>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>${message(code: 'index.title', default: 'Estouro De Pilha')}</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 0.7em .3em;
				width: 12em;
				float: right;
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
			
		 	#status2 {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 0.7em .3em;
				width: 12em;
				float: right;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status2 {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status2 ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status2 li {
				line-height: 1.3;
			}

			#status2 h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin-right: 17em;
				margin-top: 2em;
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
				#status2
				{
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
			<table>
				<tr>
					<td>
						<img src="images/logo_gauche.png" />
					</td>
				</tr>
				<tr>
					<td>
						<h1>${message(code: 'index.recentTags', default: 'Recent Tags')}</h1>
						<table>
							<g:if test="${tagList}">			
								<g:each in="${tagList}" var="t">
									<tr>
										<td>
											<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${fieldValue(bean: t, field: "tagname")}</g:link>
											x ${t.questions.size()}
										</td>
									</tr>
								</g:each>
							</g:if>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="page-body" role="main">
			<g:if test="${flash.message}">
		        <div class="message">${flash.message}</div>
		    </g:if>
		    <!-- List questions -->
		    <div id="questions">
    			<g:render template="/question/listQuestions" model="[questionList: questionList]"/>
			</div>			
		</div>
	</body>
</html>

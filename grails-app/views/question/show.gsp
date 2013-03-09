
<%@ page import="fr.isima.estouroDePilha.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title>${questionInstance.subject}</title>
	</head>
	<body>
		<a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
	
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${questionInstance?.id}" />
				<g:editQuestionControl authorId="${questionInstance.author?.id}" questionId="${questionInstance.id}"/>
			</fieldset>
		</g:form>
		<div id="show-question" class="content scaffold-show" role="main">
			<h1>
				<g:if test="${questionInstance?.subject}">
					<span class="property-value" style="word-wrap: break-word" aria-labelledby="subject-label"><g:fieldValue bean="${questionInstance}" field="subject"/></span>		
				</g:if>	
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list question">
			
			<table>
				<tr>
					<td width="15%;">
						<div>
							<div id="post-${questionInstance.id}">
						      <g:render template="/post/votes" model="[post:questionInstance]"/>
						    </div>
					    </div>
					</td>
					<td>
						<g:if test="${questionInstance?.message}">	
							<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${questionInstance}" field="message"/></span>
						</g:if>
						
						<div class="post-signature owner">
							<g:if test="${questionInstance?.postedDate}">
							<li class="fieldcontain">
									<span class="property-value" aria-labelledby="postedDate-label"><g:formatDate date="${questionInstance?.postedDate}" format="dd/MM/yyyy - HH:mm" /></span>					
							</li>
							</g:if>
							<g:if test="${questionInstance?.author}">
							<li class="fieldcontain">
								<g:link controller="User" action="show" id="${questionInstance.author.id}"><span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${questionInstance}" field="author.pseudo"/></span></g:link>
							</li>
							</g:if>
						</div>
						<li class="fieldcontain">
							<span id="nbViews-label" class="property-label"><g:message code="question.nbViews.label" default="viewed" /></span>	
							<span class="property-value" aria-labelledby="nbViews-label"><g:fieldValue bean="${questionInstance}" field="nbViews"/></span>
						</li>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<g:if test="${questionInstance?.tags}">
						<li class="fieldcontain">				
							<g:each in="${questionInstance.tags.sort{it.tagname}}" var="t">
								<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${fieldValue(bean: t, field: "tagname")}</g:link>
							</g:each>
						</li>
						</g:if>
					</td>
				</tr>
			</table>
			
			<g:link url="[controller: 'comment', action: 'create', params: [postId: questionInstance.id]]">${message(code: 'question.show.addComment', default: 'Add a comment')}</g:link><br><br>			
			<g:if test="${questionInstance?.comments}">
				<g:render template="/comment/listComments" model="[comments : questionInstance.comments.sort{it.postedDate}]"></g:render>
			</g:if>
			
			
			<g:if test="${questionInstance?.answers}">
				<!-- Buttons to sort answers -->
				<div class="buttons" style="float: right;">
					<g:remoteLink controller="question" action="sortAnswersByDate" id="${questionInstance?.id}" update="answers">${message(code: 'question.show.oldest', default: 'oldest')}</g:remoteLink>
					<g:remoteLink controller="question" action="sortAnswersByVotes" id="${questionInstance?.id}" update="answers">${message(code: 'question.show.votes', default: 'votes')}</g:remoteLink>
				</div>
				<h1>
					${questionInstance.answers.size()} ${message(code: 'question.show.answers', default: 'Answers')}
				</h1>
				<br>
				<!-- List answers -->
			    <div id="answers">
     				<g:render template="/answer/listAnswers" var="answer" collection="${questionInstance.answers.sort{it.postedDate}}"/>
				</div>
			</g:if>		
			
			
			<!-- Form to answer the question -->
			<h1>
				<span class="property-value" aria-labelledby="subject-label">${message(code: 'question.show.yourAnswer', default: 'Your Answer')}</span>		
			</h1>
			
			<g:form controller="question" action="addAnswer" id="${questionInstance.id}">	
		        <g:textArea class="property-value" style="width:90%; height:200px;" name="messageAnswer" id="messageAnswer"/>
		        <g:submitButton update="answers" name="postAnswer" style="background-color: #4a6b82; color:white;" value="Post Your Answer" />
		    </g:form>	
			</ol>
			
			
		</div>
	</body>
</html>

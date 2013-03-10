<tr>
<td style="word-wrap: break-word">
	<b style="color:#046380; font-size: 9"><g:link controller="Question" action="show" id="${question.id}">${question.subject}</g:link></b><br>
	${message(code: 'question.listQuestions.author', default: 'Author')} : <g:link controller="User" action="show" id="${question.author.id}"><span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${question}" field="author.pseudo"/></span></g:link><br>
	${message(code: 'question.listQuestions.date', default: 'date')} : <g:formatDate date="${question.postedDate}" format="dd/MM/yyyy - HH:mm"/><br><br>
	<div style="white-space:nowrap; width:100%; overflow:hidden; text-overflow:ellipsis">
		${question.message}
	</div>
</td>
						
<td width="10%;"><br>
	${question.nbViews} ${message(code: 'question.listQuestions.views', default: 'views')}<br>
	${question.nbVotes} ${message(code: 'question.listQuestions.votes', default: 'votes')}
</td>

<tr>
	<td>
		<g:if test="${question.tags}">			
			<g:each in="${question.tags.sort{it.tagname}}" var="t">
			<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${t.tagname}</g:link>
			</g:each>
		</g:if>
	</td>
</tr>
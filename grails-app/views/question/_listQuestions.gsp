
<table>
	<tr>
		
		<td>
		<b style="color:#046380; font-size: 9"><g:link controller="Question" action="show" id="${question.id}">${question.subject}</g:link></b><br>
		Author : ${question.author.pseudo}<br>
		date : <g:formatDate date="${question.postedDate}" format="dd/MM/yyyy - HH:mm"/><br><br>
		${question.message}
		</td>
							
		<td width="10%;"><br>
		${question.nbViews} views<br>
		${question.nbVotes} votes
		</td>
	</tr>
	<tr>
		<td>
			<g:if test="${question.tags}">			
				<g:each in="${question.tags.sort{it.tagname}}" var="t">
				<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${t.tagname}</g:link>
				</g:each>
			</g:if>
		</td>
	</tr>
</table>

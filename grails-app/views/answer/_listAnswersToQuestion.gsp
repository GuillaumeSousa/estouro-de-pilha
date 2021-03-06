<div>
	<table>
		<tr>
			<td width="15%;">
				<div id="post-${answer.id}">
				      <g:render template="/post/votes" model="[post:answer]"/>
				      <g:deleteAnswerControl answerId="${answer?.id}"/>
			    </div>
			</td> 
			<td>
				${answer.message}
				
				<div class="post-signature owner">
					<li class="fieldcontain">
						<span class="property-value" aria-labelledby="postedDate-label">
							<g:formatDate date="${answer.postedDate}" format="dd/MM/yyyy - HH:mm" />
						</span>					
					</li>
					
					<li class="fieldcontain">
						<g:link controller="User" action="show" id="${answer.author.id}">
							<span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${answer}" field="author.pseudo"/>
							</span>
						</g:link>
					</li>
				</div>
				<br>
				<g:link url="[controller: 'comment', action: 'create', params: [postId: answer.id]]">${message(code: 'answer.addComment', default: 'Add a comment')}</g:link><br><br>			
				<g:if test="${answer?.comments}">
					<g:render template="/comment/listComments" model="[comments : answer.comments.sort{it.postedDate}]"></g:render>
				</g:if>
			</td>
			<td width="25%;">
				<h1>${message(code: 'answer.relatedQuestion', default: 'Related Question')}<h1>
				<g:link controller="Question" action="show" id="${answer.question.id}">${answer.question.subject}</g:link>
				<br>
				<g:if test="${answer.question.tags}">			
					<g:each in="${answer.question.tags}" var="t">
						<g:link class="post-tag" controller="Tag" action="taggedQuestions" id="${t.id}">${fieldValue(bean: t, field: "tagname")}</g:link>
					</g:each>
				</g:if>
			</td>
		</tr>
		
	</table>
</div>
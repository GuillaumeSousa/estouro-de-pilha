<div>


<table style="table-layout: fixed; width: 100%">
	<tr>
		<td width="15%;" style="word-wrap: break-word">
			<div id="post-${answer.id}">
			      <g:render template="/post/votes" model="[post:answer]"/>
			      <g:deleteAnswerControl answerId="${answer?.id}"/>
		    </div>
		</td> 
		<td style="word-wrap: break-word">
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
	</tr>
	
</table>

</div>
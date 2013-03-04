<div>


<table>
	<tr>
		<td>
			<div id="post-${answer.id}">
			      <g:render template="/post/votes" model="[post:answer]"/>
		    </div>
		</td> 
		<td>
			${answer.message}
			
			<div class="post-signature owner">
				<li class="fieldcontain">
						<span class="property-value" aria-labelledby="postedDate-label">
							<g:formatDate date="${answer.question.postedDate}" format="dd/MM/yyyy - HH:mm" />
						</span>					
				</li>
				
				<li class="fieldcontain">
					<g:link controller="User" action="show" id="${answer.question.author.id}">
						<span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${answer}" field="question.author.pseudo"/>
						</span>
					</g:link>
				</li>
			</div>
			<br>
			<g:link url="[controller: 'comment', action: 'create', params: [postId: answer.id]]">add a comment</g:link><br><br>			
				<g:if test="${answer?.comments}">
					<g:render template="/comment/listComments" var="comment" collection="${answer.comments}"/>
			</g:if>
		</td>
	</tr>
	
</table>

</div>
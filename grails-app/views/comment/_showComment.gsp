<div aria-labelledby="comments-label">
	${comment.message}
	<br> 
	<g:link controller="User" action="show" id="${questionInstance.author.id}"><span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${comment}" field="author.pseudo"/></span></g:link> - <g:formatDate date="${comment.postedDate}" format="dd/MM/yyyy - HH:mm" />
</div>
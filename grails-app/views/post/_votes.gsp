<div>
	<g:remoteLink controller="post" action="incrVotes" id="${post.id}" update="postVotes-${post.id}">
	   <g:img dir="images" file="arrow-up.png" width="40px" height="40px"/>
	</g:remoteLink>
	
	<div class="property-value" style="margin-left: 10px;" id="postVotes-${post.id}">
		${post.nbVotes}
	</div> 
	
	<g:remoteLink controller="post" action="decrVotes" id="${post.id}" update="postVotes-${post.id}">
	   <g:img dir="images" file="arrow-down.png" width="40px" height="40px"/>
	</g:remoteLink>
	
</div>
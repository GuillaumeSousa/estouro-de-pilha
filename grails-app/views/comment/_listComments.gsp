<table>
	<%def i = 0 %>
	<g:each in="${comments}" var="c">
	<tr style="background-color: #E2E6E5;" width="100%;">	
		<td style="color: #fe7a15;" width="5%;">
			<%= ++i %>
		</td>
		<td>
			<g:render template="/comment/showComment" model="[comment: c]" />
		</td>
		<td width="5%;">
			<g:deleteCommentControl commentId="${c?.id}"/>
		</td>
	</tr>
	</g:each>
</table>

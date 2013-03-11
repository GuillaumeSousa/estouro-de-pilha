
<table style="table-layout: fixed; width: 100%">
	<g:each in="${questionList}" var="question">
		<g:render template="/question/displayQuestion" model="[question : question]" />
	</g:each>
</table>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>${message(code: 'user.listuserquestions.title', default: 'User Questions List') }</title>
</head>
<body>
  	<div class="body">
		<!-- List questions -->
		<div id="questions">
			<g:render template="/question/listQuestions" var="question" collection="${questionInstanceList}"/>
		</div>	
	</div>
</body>
</html>
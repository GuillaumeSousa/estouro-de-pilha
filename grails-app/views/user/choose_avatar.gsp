<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>${message(code: 'user.choose_avatar.title', default: 'Choose your avatar')}</title>
</head>
<body>
  <div class="body">
  	<fieldset>
	  <legend>${message(code: 'user.choose_avatar.legend', default: 'Update your avatar')}</legend>
	  			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
	  <g:form action="upload_avatar" method="post" enctype="multipart/form-data">
	    <label for="avatar">${message(code: 'user.choose_avatar.avatar.label', default: 'Avatar (256k max)')}</label>
	    <input type="file" name="avatar" id="avatar" />
	    <div style="font-size:0.8em; margin: 1.0em;">
	      ${message(code: 'user.choose_avatar.tip', default: 'Try to use picture with 4:5 ratio')}
	    </div>
	    <input type="submit" class="buttons" value="Upload" />
	  </g:form>
	</fieldset>
  </div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Choose your avatar</title>
</head>
<body>
  <div class="body">
  	<fieldset>
	  <legend>Upload your avatar</legend>
	  <g:form action="upload_avatar" method="post" enctype="multipart/form-data">
	    <label for="avatar">Avatar (16K)</label>
	    <input type="file" name="avatar" id="avatar" />
	    <div style="font-size:0.8em; margin: 1.0em;">
	      For best results, your avatar should have a width-to-height ratio of 4:5.
	      For example, if your image is 80 pixels wide, it should be 100 pixels high.
	    </div>
	    <input type="submit" class="buttons" value="Upload" />
	  </g:form>
	</fieldset>
  </div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 1/28/2019
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Form</title>
</head>
<body>

      <form action="us" method="post" enctype="multipart/form-data">

          Name <input type="text" name="name"/></br>
           Choose file <input type="file" name="filename" multiple="multiple"/><br>
          <input type="submit" value="download"/>

      </form>

</body>
</html>

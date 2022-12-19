<%@ page import="kz.bitlab.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/5/22
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      User user= (User)request.getSession().getAttribute("pol");
      %>
    <h2>
    Hello <%=user.getFullname()%><br><br>
    Age: <%=user.getAge()%><br><br>
    Login: <%=user.getLogin()%>
    </h2>
</body>
</html>

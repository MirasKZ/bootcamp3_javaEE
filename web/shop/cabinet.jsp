<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/14/22
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="bootstrapstyle.jsp"%>

</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
    <%@include file="navbar2.jsp"%>
    <%@include file="header.jsp"%>
    <div class="container mt-2">


        <h1>Hello <%=user.getFullname()%></h1>
            <a href="/shopchangepassword" class="btn btn-sm btn-primary">CHANGE PASSWORD</a>
    </div>
</body>
</html>

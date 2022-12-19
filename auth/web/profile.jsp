<%@ page import="kz.bitlab.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <h1>Welcome
            <%
                User currentUser = (User) session.getAttribute("currentUser");
            %>
            <%=currentUser!=null?currentUser.getFullName():""%>
        </h1>
        <br>
        <a href="/logout">LOGOUT</a>
        <br>
        <br>
        <a href="/">HOME PAGE</a>
    </body>
</html>
<%@ page import="kz.bitlab.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <%@include file="head2.jsp"%>
    <body>
    <%@include file="authNavbar.jsp"%>
    <div class="container mt-3">
        <h1>Welcome
            <%
                User currentUser = (User) session.getAttribute("currentUser");
            %>
            <%=currentUser!=null?currentUser.getFullname():""%>
        </h1>
        <br>
        <a href="/logout">LOGOUT</a>
        <br>
        <br>
        <a href="/">HOME PAGE</a>
    </div>
    </body>
</html>
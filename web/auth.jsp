<%@ page import="kz.bitlab.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/6/22
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head2.jsp"%>
<body>
<%@include file="authNavbar.jsp"%>
<div class="container mt-3">
<%
    User user = (User) session.getAttribute("currentUser");
    if(user!=null){
%>
<h1>Hi, <%=user.getFullname()%></h1>
<a href="/profile">GO TO PROFILE</a>
<%
}else{
%>
<%
    String userError = request.getParameter("usererror");
%>
<%
    if(userError!=null){
%>
<h3 style="color: red;">Incorrect email, user doesn't exist!</h3>
<%
    }
%>
<%
    String passError = request.getParameter("passworderror");
%>
<%
    if(passError!=null){
%>
<h3 style="color: red;">Incorrect password, try again!</h3>
<%
    }
%>

<form action="/auth" method="post">
    <div style="width: 42%;" class="mt-3">
        <div class="row g-2">
            <div class="col-auto">
                <label for="staticEmail2" class="visually-hidden">Email</label>
                <input type="text" readonly class="form-control-plaintext" id="us_em1" value="Login">
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">Password</label>
                <input type="text" class="form-control" id="us_em2" placeholder="Login" name="login">
            </div>
        </div>
        <div class="row g-2 mt-1">
            <div class="col-auto">
                <label for="staticEmail2" class="visually-hidden">Email</label>
                <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Password">
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">Password</label>
                <input type="password" class="form-control" id="inputPassword2" placeholder="Password" name="password">
            </div>
        </div>
        <button class="btn btn-primary">SIGN IN</button>
    </div>
</form>
</div>
<%
    }
%>
</body>
</html>

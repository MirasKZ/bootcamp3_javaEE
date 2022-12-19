<%@ page import="kz.bitlab.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <%
            User user = (User) session.getAttribute("currentUser");
            if(user!=null){
        %>
            <h1>Hi, <%=user.getFullName()%></h1>
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
                EMAIL : <input type="email" name="email">
                PASSWORD : <input type="password" name="password">
                <button>SIGN IN</button>
            </form>
        <%
            }
        %>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <form action="/session" method="post">
            NAME : <input type="text" name="user_name">
            SURNAME : <input type="text" name="user_surname">
            <button>SEND DATA</button>
        </form>
        <h1>
            CURRENT SAVE USER IS
            <%
                String name = (String) session.getAttribute("userName");
                String surname = (String) session.getAttribute("userSurname");
                if(name==null) name = "Default name";
                if(surname==null) surname = "Default surname";
            %>
            <%=(name+" "+surname)%>
        </h1>
        <a href="/clearsession">CLEAR DATA</a>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <form action="/step-one" method="post">
            NAME : <input type="text" name="user_name">
            SURNAME : <input type="text" name="user_surname">
            AGE :
            <select name="user_age">
                <%
                    for(int i=0;i<120;i++){
                %>
                    <option><%=i%></option>
                <%
                    }
                %>
            </select>
            <button>NEXT</button>
        </form>
    </body>
</html>
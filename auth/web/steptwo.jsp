<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <form action="/step-two" method="post">
            CITY :
            <select name="user_city">
                <option>Almaty</option>
                <option>Astana</option>
                <option>Paris</option>
                <option>Kostanay</option>
            </select>
            ADDRESS : <input type="text" name="user_address">
            PHONE : +7 <input type="number" name="user_phone">

            <button>NEXT</button>
        </form>
    </body>
</html>
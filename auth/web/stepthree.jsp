<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <form action="/step-three" method="post">
            UNIVERSITY :
            <select name="user_university">
                <option>Harvard</option>
                <option>MIT</option>
                <option>Oxford</option>
                <option>Politeh</option>
            </select>
            FACULTY :
            <select name="user_faculty">
                <option>IT</option>
                <option>Business</option>
                <option>Finance</option>
                <option>Marketing</option>
                <option>Engineering</option>
                <option>Art</option>
                <option>Architecture</option>
            </select>
            GROUP : <input type="text" name="user_group">
            <button>FINISH</button>
        </form>
    </body>
</html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Tovar" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/5/22
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        ArrayList<Tovar> tovary= (ArrayList<Tovar>) request.getAttribute("tov2");
        if(tovary!=null){
            for(Tovar tov: tovary){
%>
<div style="margin-bottom: 10px;border: 1px solid black;display: flex; width: 30%;">
    <form action="/mainTov" method="post">
        <input type="hidden" name="id" value="<%=tov.getId()%>">
        <h2><%=tov.getName()%></h2>
        <p><%=tov.getPrice()%></p>
        <button type="submit" style="color: white;background-color: blue; "><b>ADD TO CARD</b></button>
    </form>

</div>
<%
        }
    }
%>
</body>
</html>

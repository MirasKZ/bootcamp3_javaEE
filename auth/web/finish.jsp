<%@ page import="kz.bitlab.dto.ClientFormDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head></head>
    <body>
        <%
            ClientFormDto client = (ClientFormDto) request.getSession().getAttribute("CURRENT_SAVE_USER");
            if(client!=null){
        %>
            <h1>
                Name : <%=client.getName()%><br><br>
                Surname : <%=client.getSurname()%><br><br>
                Age : <%=client.getAge()%><br><br>
                City : <%=client.getCity()%><br><br>
                Address : <%=client.getAddress()%><br><br>
                Phone : <%=client.getPhone()%><br><br>
                University : <%=client.getUniversity()%><br><br>
                Faculty : <%=client.getFaculty()%><br><br>
                Group : <%=client.getGroup()%><br><br>
            </h1>
        <%
            }
        %>
    </body>
</html>
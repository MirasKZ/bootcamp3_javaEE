<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="kz.bitlab.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/29/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp"%>


</head>
<body>
<%@include file="head.jsp"%>
<div class="container mt-3">
    <% Student student=(Student) request.getAttribute("details");
        if(student!=null){
    %>
        <table class="table" style="width:40%;">
            <tbody>
                <tr>
                    <td> NAME : </td>
                    <th scope="row"><label><%=student.getName()%></label></th>
                </tr>
                <tr>
                    <td>SURNAME : </td>
                    <th scope="row"><label><%=student.getSurname()%></label> </th>

                </tr>
                <tr>
                    <td>BIRTHDATE : </td>
                    <th scope="row"><label><%=student.getBirthdate()%></label></th>
                </tr>
                <tr>
                    <td>CITY : </td>
                    <th scope="row"><label><%=student.getCity().getName()%></label> </th>
                </tr>
            </tbody>
        </table>
        <a href="/edit?id=<%=student.getId()%>"><button class="btn btn-primary btn-sm">EDIT</button></a>

</div>
    <!-- Button trigger modal -->

    <!-- Modal -->


    <%}
        else{
            %>
                <h1 class="text-center">404 ITEM NOT FOUND!</h1>
            <%
        }
        %>
</div>

</body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %><%--
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" type="text/css">


</head>
<body>
<%@include file="head.jsp"%>
<div class="container">
    <% String success=request.getParameter("success");
        if(success!=null){
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Student added successfully!
    </div>
    <%
        }
    %>
        <div class="container mt-3">
            <form action="/addstudent" method="post">
                <table class="table" >
                    <tbody>
                    <tr>
                        <td> NAME : </td>
                        <td> <input type="text" placeholder="insert name" name="st_na"></td>
                    </tr>
                    <tr>
                        <td>SURNAME : </td>
                        <td> <input type="text" placeholder="insert surname" name="st_su"></td>

                    </tr>
                    <tr>
                        <td>BIRTHDATE : </td>
                        <td><input type="date"  name="st_bi"></td>
                    </tr>
                    <tr>
                        <td>CITY : </td>
                        <td><input type="text" placeholder="insert city" name="st_ci"></td>
                    </tr>
                    </tbody>
                </table>
                <button class="btn btn-success btn-sm">ADD STUDENT</button>

            </form>
        </div>

</body>
</html>

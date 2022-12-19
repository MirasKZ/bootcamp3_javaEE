<%@ page import="kz.bitlab.model.Student" %>
<%@ page import="kz.bitlab.model.City" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/2/22
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="head.jsp"%>
<%
    City city = (City) request.getAttribute("cityDet");
    if(city!=null){
%>
    <div class="container mt-3">
        <form action="/savecity" method="post">
        <input type="hidden" value="<%=city.getId()%>" name="id">
        <table class="table" >
            <tbody>
            <tr>
                <td> NAME : </td>
                <td> <input type="text" value="<%=city.getName()%>" name="ct-na"></td>
            </tr>
            <tr>
                <td>CODE : </td>
                <td> <input type="text" value="<%=city.getCode()%>" name="ct-co"></td>

            </tr>
            </tbody>
        </table>
            <button type="submit" class="btn btn-success btn-sm">SAVE</button>
            <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
                DELETE
            </button>
        </form>
    </div>
        <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/deletecity" method="post">
                        <input type="hidden" name="id" value="<%=city.getId()%>">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirm Delete</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                            <button type="submit" class="btn btn-primary">Yes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

<%
    }
    else{
%>

<%
    }
%>
</body>
</html>

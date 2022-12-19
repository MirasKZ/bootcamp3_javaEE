<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.*" %><%--
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
    <%@include file="bootstrapstyle.jsp"%>

</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
<%@include file="navbar2.jsp"%>
<%@include file="header.jsp"%>


<div class="container mt-3">
    <% Type type=(Type) request.getAttribute("tipdetal");
        if(type!=null){
    %>
    <form action="/savetype" method="post">
        <input type="hidden" value="<%=type.getId()%>" name="id">
    <table class="table" style="width:40%;">
        <tbody>
        <tr>
            <td> NAME : </td>
            <td><input type="text" placeholder="Insert name" name="type_name" value="<%=type.getName()%>"></td>
        </tr>
        </tbody>
    </table>
        <button type="submit" class="btn btn-success btn-sm"> SAVE TYPE</button>
        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
            DELETE TYPE
        </button>
    </form>
</div>

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/deletetype" method="post">
                    <input type="hidden" name="id" value="<%=type.getId()%>">
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

    <%}
        else{
            %>
                <h1 class="text-center">404 ITEM NOT FOUND!</h1>
            <%
        }
        %>


</body>
</html>

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

    <div class="container mt-2">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addTypeModal">
        Add type
    </button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="addTypeModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">New type</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/addtype" method="post">
                        <table class="table" >
                            <tbody>
                            <tr>
                                <td> NAME : </td>
                                <td> <input type="text" placeholder="insert name" name="type_name"></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success ">ADD TYPE</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <div class="container mt-3">
    <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Details</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<Type> types=(ArrayList<Type>) request.getAttribute("tipy");
                                    if(types!=null){
                                        for(Type t : types){
                                %>

                                <tr>
                                    <td><%=t.getId()%></td>
                                    <td><%=t.getName()%></td>
                                    <td><a href="/typedetails?id=<%=t.getId()%>"><button class="btn btn-success btn-sm">Details</button></a> </td>
                                    </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
            </div>


</body>
</html>

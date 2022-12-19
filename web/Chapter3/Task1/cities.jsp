<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="kz.bitlab.model.Student" %>
<%@ page import="kz.bitlab.model.City" %><%--
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
    <div class="container mt-2">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addCityModal">
        Add new
    </button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="addCityModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">New city</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/addcity" method="post">
                        <table class="table" >
                            <tbody>
                            <tr>
                                <td> NAME : </td>
                                <td> <input type="text" placeholder="insert name" name="ct_na"></td>
                            </tr>
                            <tr>
                                <td>Code : </td>
                                <td> <input type="text" placeholder="insert code" name="ct_co"></td>

                            </tr>
                            </tbody>
                        </table>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success btn-sm">ADD CITY</button>
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
                                    <th>Code</th>
                                    <th>Details</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<City> Cities =(ArrayList<City>) request.getAttribute("goroda");
                                    if(Cities!=null){
                                        for(City ct:Cities){
                                %>

                                <tr>
                                    <td><%=ct.getId()%></td>
                                    <td><%=ct.getName()%></td>
                                    <td><%=ct.getCode()%></td>
                                    <td><a href="/cityDetails?id=<%=ct.getId()%>"><button class="btn btn-success btn-sm">Details</button></a> </td>
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

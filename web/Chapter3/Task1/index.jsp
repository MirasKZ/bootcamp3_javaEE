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
    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addStudModal">
        Add new
    </button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="addStudModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Add new student</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
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
                                <td>
                                    <select name="st_ci" class="form-select">
                                        <%
                                            ArrayList<City> cities=(ArrayList<City>) request.getAttribute("goroda");
                                            if(cities!=null){
                                                for(City ct:cities){
                                        %>
                                        <option value="<%=ct.getId()%>">
                                            <%=ct.getName()%>
                                        </option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success btn-sm">ADD STUDENT</button>
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
                                    <th>Surname</th>
                                    <th>Birthdate</th>
                                    <th>City</th>
                                    <th>Details</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<Student> students =(ArrayList<Student>) request.getAttribute("studenty");
                                    if(students!=null){
                                        for(Student st:students){
                                %>

                                <tr>
                                    <td><%=st.getId()%></td>
                                    <td><%=st.getName()%></td>
                                    <td><%=st.getSurname()%></td>
                                    <td><%=st.getBirthdate()%></td>
                                    <td><%=st.getCity().getName()%></td>
                                    <td><a href="/studDetails?id=<%=st.getId()%>"><button class="btn btn-success btn-sm">Details</button></a> </td>
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

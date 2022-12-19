<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="kz.bitlab.model.Country" %><%--
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
<div class="container">
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Mobile shop</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/additem">Add Item</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</div>
<div class="container">
    <% String success=request.getParameter("success");
        if(success!=null){
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Item added successfully!
    </div>
    <%
        }
    %>
    <form action="/additem" method="post">
        <table class="table" style="width:40%;">
            <tbody>
            <tr>
                <td> NAME : </td>
                <td><input type="text" placeholder="Insert name" name="it_na"></td>
            </tr>
            <tr>
                <td>Country : </td>
                <td>
                    <select name="it_co" class="form-select">
                        <%
                            ArrayList<Country> countries=(ArrayList<Country>) request.getAttribute("strany");
                            if(countries!=null){
                                for(Country cn:countries){
                        %>
                            <option value="<%=cn.getId()%>">
                                <%=cn.getName()+"/"+cn.getCode()%>
                            </option>
                        <%
                                  }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Price : </td>
                <td><input type="number" placeholder="Insert price" name="it_pr"></td>
            </tr>
            <tr>
                <td>Amount : </td>
                <td><input type="number" placeholder="Insert amount" name="it_am"></td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="btn btn-success btn-sm"> ADD ITEM</button>
    </form>

</div>

</body>
</html>

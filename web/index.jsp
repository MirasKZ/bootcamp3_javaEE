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

    <div class="container mt-3">
        <div class="row">
        <table cellpadding="10" >
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Country</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Details</th>
            </tr>
            </thead>
        <tbody>
        <%
            ArrayList<Item> items =(ArrayList<Item>) request.getAttribute("tovary");
            if(items!=null){
                for(Item it:items){
        %>
            <tr>
                <td><%=it.getId()%></td>
                <td><%=it.getName()%></td>
                <td><%=it.getCountry().getName()+"/"+it.getCountry().getCode()%></td>
                <td><%=it.getPrice()%></td>
                <td><%=it.getAmount()%></td>
                <td><a href="/details?id=<%=it.getId()%>"><button class="btn btn-success btn-sm">Details</button></a> </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
        </table>
        </div>
    </div>
</body>
</html>

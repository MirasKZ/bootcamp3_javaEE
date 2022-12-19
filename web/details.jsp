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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


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
    <% Item item=(Item) request.getAttribute("details");
        if(item!=null){
    %>
    <form action="/saveitem" method="post">
        <input type="hidden" value="<%=item.getId()%>" name="id">
    <table class="table" style="width:40%;">
        <tbody>
        <tr>
            <td> NAME : </td>
            <td><input type="text" placeholder="Insert name" name="it_na" value="<%=item.getName()%>"></td>
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
                        <option value="<%=cn.getId()%>" <%=(item.getCountry().getId()==cn.getId()?"selected":"")%>>
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
            <td><input type="number" placeholder="Insert price" name="it_pr" value="<%=item.getPrice()%>"></td>
        </tr>
        <tr>
            <td>Amount : </td>
            <td><input type="number" placeholder="Insert amount" name="it_am" value="<%=item.getAmount()%>"></td>
        </tr>
        </tbody>
    </table>
        <button type="submit" class="btn btn-success btn-sm"> SAVE ITEM</button>
        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
            DELETE ITEM
        </button>
    </form>
</div>

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/deleteitem" method="post">
                    <input type="hidden" name="id" value="<%=item.getId()%>">
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

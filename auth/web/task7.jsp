<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Footballer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" type="text/css">
    </head>
    <body style="min-height: 800px;">
        <div class="container">
            <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/">Footballers</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="/">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/">About</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="container mt-3">
            <div class="row">
                <div class="col-6 mx-auto">
                    <form action="/task7" method="post">
                        <div class="row">
                            <div class="col-12">
                                <label>NAME : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" placeholder="Name" name="name">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>SURNAME : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" placeholder="Surname" name="surname">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>CLUB : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <select class="form-select" name="club">
                                    <option>Real Madrid CF</option>
                                    <option>Atalanta</option>
                                    <option>Real Sociedad</option>
                                    <option>Barcelona</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>SALARY : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="number" class="form-control" placeholder="Salary" name="salary">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>TRANSFER PRICE : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="number" class="form-control" placeholder="Transfer Price" name="price">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <button class="btn btn-success">ADD FOOTBALLER</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container mt-3">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>NAME </th>
                        <th>SURNAME </th>
                        <th>CLUB </th>
                        <th>SALARY </th>
                        <th>TRANSFER PRICE </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("futbolisty");
                        if(footballers!=null){
                            for(Footballer footballer : footballers){
                    %>
                        <tr>
                            <td>
                                <%=footballer.getName()%>
                            </td>
                            <td>
                                <%=footballer.getSurname()%>
                            </td>
                            <td>
                                <%=footballer.getClub()%>
                            </td>
                            <td>
                                <%=footballer.getSalary()%>
                            </td>
                            <td>
                                <%=footballer.getPrice()%>
                            </td>
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

<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container mt-3" style="min-height: 800px;">

            <div class="row">
                <div class="col-6 mx-auto">
                    <%
                        String success = request.getParameter("success");
                        if(success!=null){
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Item added successfully!
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%
                        }
                    %>
                    <form action="/additem" method="post">
                        <div class="row">
                            <div class="col-12">
                                <label>NAME : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" placeholder="Name" name="item_name">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>COUNTRY : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <select class="form-select" name="item_country">
                                    <%
                                        ArrayList<Country> countries =
                                                (ArrayList<Country>) request.getAttribute("strany");
                                        if(countries!=null){
                                            for(Country cn : countries){
                                    %>
                                        <option value="<%=cn.getId()%>">
                                            <%=cn.getName() + " / " + cn.getCode()%>
                                        </option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>PRICE : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="number" class="form-control" placeholder="Price" name="item_price">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>AMOUNT : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="number" class="form-control" placeholder="Amount" name="item_amount">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <button class="btn btn-success">ADD ITEM</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

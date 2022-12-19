<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp" %>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-3" style="min-height: 800px;">
    <div class="row">
        <div class="col-6 mx-auto">
            <%
                Item item = (Item) request.getAttribute("item");
                if (item != null) {
            %>
            <form action="/saveitem" method="post">
                <input type="hidden" name="id" value="<%=item.getId()%>">
                <div class="row">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="Name"
                               name="item_name" value="<%=item.getName()%>">
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
                                <option value="<%=cn.getId()%>" <%=(item.getCountry().getId()==cn.getId()?"selected":"")%> >
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
                        <input type="number" class="form-control"
                               placeholder="Price" name="item_price" value="<%=item.getPrice()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>AMOUNT : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="number" class="form-control"
                               placeholder="Amount" name="item_amount" value="<%=item.getAmount()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">SAVE ITEM</button>
                        <button type="button" class="btn btn-danger ms-2" data-bs-toggle="modal" data-bs-target="#deleteModal">
                            DELETE ITEM
                        </button>
                    </div>
                </div>
            </form>
            <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="deleteitem" method="post">
                            <input type="hidden" name="id" value="<%=item.getId()%>">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirm Delete</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                                <button class="btn btn-primary">YES</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%
            } else {
            %>
            <h1 class="text-center">404 ITEM NOT FOUND</h1>
            <%
                }
            %>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>

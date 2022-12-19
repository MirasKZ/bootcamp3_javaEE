<%@ page import="kz.bitlab.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.ShopItem" %>
<%@ page import="kz.bitlab.db.DBUtil" %>
<%@ page import="kz.bitlab.model.Type" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <%@include file="shopstyle.jsp"%>
    <%@include file="bootstrapstyle.jsp"%>
</head>
<body>
<%

    User user= (User) request.getSession().getAttribute("currentUser");


%>
<!-- Navigation-->
<%@include file="navbar2.jsp"%>
<%@include file="header.jsp"%>

<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/shopadditem" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>TYPE: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <%
                            ArrayList<Type> types=(ArrayList<Type>) request.getAttribute("tipy");
                            if(types!=null){
                        %>
                        <select name="item_type" class="form-select">
                            <%
                                for(Type t:types){
                            %>
                            <option value="<%=t.getId()%>"><%=t.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%
                            }
                        %>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-12">
                        <label>NAME: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="Name" name="item_name">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>DESCRIPTION: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea class="form-control" name="item_description"></textarea>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>ON SALE?: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select name="item_onsale" class="form-select">
                            <option>false</option>
                            <option>true</option>
                        </select>
                    </div>
                </div>


                <div class="row mt-3">
                    <div class="col-12">
                        <label>PRICE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-6">
                        <input type="number" class="form-control" placeholder="last price" name="item_newprice">
                    </div>
                    <div class="col-6">
                        <input type="number" class="form-control" placeholder="former price" name="item_oldprice">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>AMOUNT: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="number" class="form-control" placeholder="amount" name="item_amount">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>IS POPULAR?: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select name="item_popular" class="form-select">
                            <option>false</option>
                            <option>true</option>
                        </select>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-12">
                        <label>PHOTO URL: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="url" name="item_url">
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

<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
<%
    ArrayList<ShopItem> shopitems = (ArrayList<ShopItem>) request.getAttribute("shopitemy");
    if(shopitems!=null){
                for(ShopItem sh: shopitems){
            %>
            <form action="/addtocart" method="post">
                <input type="hidden" name="id" value="<%=sh.getId()%>">
            <div class="col mb-5">
                <div class="card h-100">
                    <%
                        if(sh.isOnSale()){
                    %>
                    <!-- Sale badge-->
                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                    <%
                        }
                    %>
                    <!-- Product image-->
                    <img class="card-img-top" style="width: 200px;height: 150px;align-self: center" src="images/<%=sh.getUrl()%>" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder"><%=sh.getName()%></h5>
                            <%if(sh.isPopular()){
                            %>
                            <!-- Product reviews-->
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            <%
                                }
                            %>
                            <!-- Product price-->
                            <%
                                if(sh.isOnSale()){
                            %>
                            <span class="text-muted text-decoration-line-through">$<%=sh.getOldprice()%></span>
                            $<%=sh.getNewprice()%>
                            <%
                                }else{
                            %>
                            $<%=sh.getNewprice()%>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center "><button class="btn btn-success" type="submit">Add to cart</button></div>
                        <div class="text-center mt-1"><a class="btn btn-secondary btn-outline-dark mt-auto" href="#">Details</a></div>
                    </div>
                </div>
            </div>
            </form>
            <%
                    }
                }
            %>
        </div>
    </div>
</section>

<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/shopTheme/js/scripts.js"></script>
</body>
</html>

<%@ page import="kz.bitlab.model.User" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/profile">Smart Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="/profile">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/profile?category=1">Laptops</a></li>
                <li class="nav-item"><a class="nav-link" href="/profile?category=2">Phone</a></li>
                <li class="nav-item"><a class="nav-link" href="/profile?category=3">Printer</a></li>
                <li class="nav-item"><a class="nav-link" href="/types">Types</a></li>
            </ul>
            <form class="d-flex" >
                <a href="/shopauth"  class="btn btn-success m-lg-1">Login</a>
                <a href="/shopregister" class="btn btn-primary m-lg-1">Sign Up</a>
                <%
                    if(user!=null){
                %>
                <div class="dropdown m-lg-1">
                    <a class="btn btn-success dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <%=user.getFullname()%>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/shopcabinet">Cabinet</a></li>
                        <li><a class="dropdown-item" href="/shoplogout">Logout</a></li>
                    </ul>
                </div>
                <%
                    }
                %>
                <a href="/cart"  class="btn btn-secondary m-lg-1">Cart</a>


            </form>
        </div>
    </div>
</nav>
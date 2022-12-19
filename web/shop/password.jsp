<%@ page import="kz.bitlab.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/14/22
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="bootstrapstyle.jsp"%>
</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
<%@include file="navbar2.jsp"%>
<%@include file="header.jsp"%>
<%
    String oldPassError=request.getParameter("oldpassworderror");
    String passError=request.getParameter("passworderror");
    String passSuccess=request.getParameter("passwordsuccess");
%>
<br>

<br>
<form action="/shopchangepassword" method="post">
    <div class="container mt-3">
        <div class="row">
            <div class="col-6 mx-auto">
                <%
                    if(oldPassError!=null){
                %>
                <div class="row mt-2">
                    <div class="col-12">
                        <strong style="color: red">Old password is not correct!</strong>
                    </div>
                </div>

                <%
                    }
                %>
                <%
                    if(passError!=null){
                %>
                <div class="row mt-2">
                    <div class="col-12">
                        <strong style="color: red;">New passwords are not same</strong>
                    </div>
                </div>

                <%
                    }
                %>
                <%
                    if(passSuccess!=null){
                %>
                <div class="row mt-2">
                    <div class="col-12">
                        <strong style="color: green;">Password update successfully!</strong>
                    </div>
                </div>

                <%
                    }
                %>


                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="password" class="form-control" placeholder="Name" name="old_password">
                        </div>
                    </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>NEW PASSWORD: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" placeholder="Name" name="new_password">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>RE NEW PASSWORD: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" placeholder="Name" name="re_new_password">
                    </div>
                </div>




                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">CHANGE PASSWORD</button>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>

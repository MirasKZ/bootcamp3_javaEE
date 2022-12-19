<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/8/22
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <%@include file="bootstrapstyle.jsp"%>
    <%@include file="authstyle.jsp"%>
</head>
<body>
<%
    String emailError = request.getParameter("emailerror");
    System.out.println(emailError);
%>

<%
    String passError = request.getParameter("passworderror");
%>
<%
    String success = request.getParameter("success");
%>

    <form action="/shopregister" method="post">
        <section class="form-01-main">
            <div class="form-cover">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-sub-main">
                                <div class="_main_head_as">
                                    <a href="#">
                                        <img src="bootstrap-5-login-page-template-with-source-code/assets/images/vector.png">
                                    </a>
                                </div>
<%--                                <div class="input-group-group">--%>
                                    <input id="email" name="email" class="form-control" type="text" placeholder="Enter Email" required>
<%--                                </div>--%>
                                <%
                                    if(emailError!=null){
                                %>
                                    <div class="form-group">
                                        <h3 style="color: red">Email is busy!</h3>
                                    </div>
                                <%
                                    }
                                %>

                                <div class="form-group">
                                    <input id="fullname" name="fullname" class="form-control _ge_de_ol" type="text" placeholder="Enter Full Name" required="" aria-required="true">
                                </div>

                                <div class="form-group">
                                    <input id="regpassword1" type="password" class="form-control" name="password" placeholder="********" required="required">
                                    <i toggle="#password" id="toggleElement1" class="fa fa-fw fa-eye toggle-password field-icon"></i>
                                </div>
                                <%
                                    if(passError!=null){
                                %>
                                <div class="form-group">
                                    <h3 style="color: red">Passwords are not same!</h3>
                                </div>
                                <%
                                    }
                                %>
                                <div class="form-group">
                                    <input id="regpassword2" type="password" class="form-control" name="re_password" placeholder="********" required="required">
                                    <i toggle="#password" id="toggleElement2" class="fa fa-fw fa-eye toggle-password field-icon"></i>
                                </div>
                                <%
                                    if(success!=null){
                                %>
                                <div class="form-group">
                                    <h3 style="color: green">Account created successfully!</h3>
                                </div>
                                <%
                                    }
                                %>

                                <div class="form-group">
                                    <div class="btn_uy">
                                        <button class="btn btn-success">Sign up</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                        <a href="/shopauth" class="btn btn-primary">Login</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
</body>
</html>

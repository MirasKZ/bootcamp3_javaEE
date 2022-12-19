<%@ page import="kz.bitlab.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/6/22
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <%@include file="bootstrapstyle.jsp"%>
  <%@include file="authstyle.jsp"%>
</head>
<body>
<%
  User user=(User) request.getSession().getAttribute("currentUser");

%>
<%@include file="navbar2.jsp"%>
<div class="container mt-3">
  <%
    if(user!=null){
  %>
  <h1>Hi, <%=user.getFullname()%></h1>
  <a href="/profile">GO TO PROFILE</a>
  <%
  }else{
  %>
  <%
    String userError = request.getParameter("usererror");
  %>

  <%
    String passError = request.getParameter("passworderror");
  %>


</div>
<form action="/shopauth" method="post">
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
              <div class="form-group">
                <input id="email" name="email" class="form-control _ge_de_ol" type="text" placeholder="Enter Email" required="" aria-required="true">
              </div>
              <%
                if(userError!=null){
              %>
              <div class="form-group">
                <p style="color: red;">Incorrect email, user doesn't exist!</p>
              </div>
              <%
                }
              %>
              <div class="form-group">
                <input id="password" type="password" class="form-control" name="password" placeholder="********" required="required">
                <i toggle="#password" id="toggleElement" class="fa fa-fw fa-eye toggle-password field-icon"></i>
              </div>

              <%
                if(passError!=null){
              %>
              <div class="form-group">
                <p style="color: red;">Incorrect password, try again!</p>
              </div>
              <%
                }
              %>

              <div class="form-group">
                <div class="check_box_main">
                  <a href="#" class="pas-text">Forgot Password</a>
                </div>
              </div>

              <div class="form-group">
                <div class="btn_uy">
                  <button class="btn btn-success">Login</button>
                  <a class="btn btn-secondary" href="/shopregister">Register</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</form>
<%
  }
%>
<script>
  function showPassword(){
    let inp = document.getElementById("password");
    inp.type="text";
  }
let toggler= document.getElementById("toggleElement");
toggler.addEventListener("click","showPassword");
</script>
</body>
</html>


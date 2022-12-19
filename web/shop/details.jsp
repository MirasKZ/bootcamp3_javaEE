<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.*" %><%--
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
    <%@include file="bootstrapstyle.jsp"%>
    <%@include file="shopstyle.jsp"%>

</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
<%@include file="navbar2.jsp"%>
<%@include file="header.jsp"%>


<div class="container mt-3">
    <% ShopItem item=(ShopItem) request.getAttribute("details");
        if(item!=null){
    %>
    <form action="/editshopitem" method="post">
        <input type="hidden" value="<%=item.getId()%>" name="id">
    <table class="table" style="width:40%;">
        <tbody>
        <tr>
            <td>
                <img src="<%=item.getUrl()%>" style="width: 200px;height: 200px;">
            </td>
            <td>
                <input type="hidden" placeholder="insert url" name="item_url" value="<%=item.getUrl()%>">
            </td>
        </tr>
        <tr>
            <td> NAME : </td>
            <td><label><%=item.getName()%></label></td>
        </tr>
        <tr>
            <td> DESCRIPTION : </td>
            <td><p><%=item.getDescription()%></p></td>
        </tr>
        <tr>
            <td>Type : </td>
            <td><label><%=item.getType().getName()%></label></td>
        </tr>
        <tr>
            <td>OnSale</td>
            <td><label><%=item.isOnSale()%></label></td>
        </tr>

        <tr>
            <td>Price : </td>
            <%
                if(item.isOnSale()){
            %>
            <td><%=item.getNewprice()%> $ <span class="text-muted text-decoration-line-through"><%=item.getOldprice()%>$</span></td>
            <%
                } else{
            %>
            <td><%=item.getNewprice()%> $</td>
            <%
                }
            %>
        </tr>

        <tr>
            <td>Popular</td>
            <td><label><%=item.isPopular()%></label></td>
        </tr>
        <tr>
            <td>Amount : </td>
            <td><label><%=item.getAmount()%></label></td>
        </tr>
        </tbody>
    </table>
        <button type="submit" class="btn btn-success btn-sm"> EDIT ITEM</button>
    </form>
</div>


<%
    if(user!=null){
%>
<div class="container mt-2">
    <form action="/addcomment" method="post">
        <input type="hidden" name="item_id" value="<%=item.getId()%>">
        <div class="row mt-2">
            <div class="col-12">
                <textarea class="form-control" name="comment_text"></textarea>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-12">
                <button class="btn btn-success">Add comment</button>
            </div>
        </div>

    </form>
</div>

<%
    }
%>
<%
    ArrayList<Comments>comments=(ArrayList<Comments>) request.getAttribute("komiki");
    if(comments!=null){
%>
<div class="container">
    Here goes the existing comments
    <hr>
    <%
        for(Comments c: comments){
    %>
        <h5><%=c.getUser().getFullname()%> at <%=c.getTimestamp()%></h5>
        <h6><%=c.getComment()%></h6>
        <hr>
    <%
        }
    %>
</div>
<%

    }
%>
    <%}
        else{
            %>
                <h1 class="text-center">404 ITEM NOT FOUND!</h1>
            <%
        }
        %>


</body>
</html>

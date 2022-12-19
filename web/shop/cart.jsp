<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="kz.bitlab.model.ShopItem" %><%--
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

</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
<%@include file="navbar2.jsp"%>
<%

    ArrayList<ShopItem> shopsiki=(ArrayList<ShopItem>) request.getSession().getAttribute("shopsiki");
    if(shopsiki!=null){
%>
<div class="container mt-3">
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Number</th>
                <th>Name</th>
                <th>Price</th>
                <th>Details</th>
            </tr>
            </thead>
            <tbody>
            <%      int i=1;
                    for(ShopItem sh:shopsiki){
            %>
            <tr>
                <td><%=i%></td>
                <td><%=sh.getName()%></td>
                <td><%=sh.getNewprice()%></td>
                <td><a type="btn" class="btn btn-success" href="/shopdetails?id=<%=sh.getId()%>">Details</a> </td>
            </tr>
            <%
                        i++;
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
